/*
 * www.javagl.de - ND - Multidimensional primitive data structures
 *
 * Copyright (c) 2013-2015 Marco Hutter - http://www.javagl.de
 * 
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package de.javagl.nd.tuples.j;

import java.util.Comparator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.LongConsumer;

/**
 * A <code>Spliterator.OfLong</code> based on a <code>LongTuple</code>.
 */
class LongTupleSpliterator implements Spliterator.OfLong
{
    /**
     * The underlying tuple
     */
    private final LongTuple tuple;

    /**
     * The start index, inclusive
     */
    private int index;

    /**
     * The end index, exclusive
     */
    private final int end;

    /**
     * The characteristics
     */
    private final int characteristics;

    /**
     * Creates a spliterator for the given tuple 
     * 
     * @param tuple The tuple. This is assumed to be unmodified while the
     * spliterator is in use.
     * @param index The start index, inclusive
     * @param end The end index, exclusive
     */
    public LongTupleSpliterator(LongTuple tuple, int index, int end)
    {
        this.tuple = tuple;
        this.index = index;
        this.end = end;
        this.characteristics =
            Spliterator.ORDERED | 
            Spliterator.IMMUTABLE | 
            Spliterator.SIZED | 
            Spliterator.SUBSIZED;
    }

    @Override
    public OfLong trySplit()
    {
        int center = (index + end) >> 1;
        if (index >= center)
        {
            return null;
        }
        LongTupleSpliterator result =
            new LongTupleSpliterator(tuple, index, center);
        index = center;
        return result;
    }

    @Override
    public void forEachRemaining(LongConsumer action)
    {
        Objects.requireNonNull(action, "The action is null");
        if (index >= 0 && end <= tuple.getSize()) 
        {
            while (index < end)
            {
                action.accept(tuple.get(index++));
            }
        }
    }

    @Override
    public boolean tryAdvance(LongConsumer action)
    {
        Objects.requireNonNull(action, "The action is null");
        if (index >= 0 && index < end)
        {
            action.accept(tuple.get(index++));
            return true;
        }
        return false;
    }

    @Override
    public long estimateSize()
    {
        return end - index;
    }

    @Override
    public int characteristics()
    {
        return characteristics;
    }

    @Override
    public Comparator<? super Long> getComparator()
    {
        return null;
    }
}

