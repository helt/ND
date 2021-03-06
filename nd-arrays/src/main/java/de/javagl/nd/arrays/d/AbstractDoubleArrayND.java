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
package de.javagl.nd.arrays.d;

import de.javagl.nd.arrays.AbstractArrayND;
import de.javagl.nd.tuples.Order;
import de.javagl.nd.tuples.i.IntTuple;

/**
 * Abstract base implementation of a {@link DoubleArrayND}.<br>
 * <br>
 * This class implements the {@link #toString()}, {@link #equals(Object)},
 * {@link #hashCode()} and {@link #subArray(IntTuple, IntTuple)} methods 
 * canonically.<br>
 */
abstract class AbstractDoubleArrayND
    extends AbstractArrayND
    implements DoubleArrayND
{
    /**
     * Create a new array with the given size.
     *
     * @param size The size
     * @param preferredIterationOrder The preferred iteration {@link Order}
     * of this array. This may be <code>null</code> if the array does not
     * have a preferred iteration order.
     * @throws NullPointerException If the given size is <code>null</code>
     * @throws IllegalArgumentException If the given size is negative
     * along any dimension
     */
    AbstractDoubleArrayND(IntTuple size, Order preferredIterationOrder)
    {
        super(size, preferredIterationOrder);
    }

    @Override
    public String toString()
    {
        return DoubleArraysND.toString(this);
    }

    @Override
    public int hashCode()
    {
        return DoubleArraysND.hashCode(this);
    }

    @Override
    public boolean equals(Object object)
    {
        return DoubleArraysND.equals(this, object);
    }


}
