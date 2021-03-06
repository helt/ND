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
package de.javagl.nd.arrays.$type.letter$;

import de.javagl.nd.tuples.Order;
import de.javagl.nd.tuples.i.IntTuple;
import de.javagl.nd.tuples.i.IntTuples;

/**
 * Implementation of a {@link Mutable$type.uppercaseName$ArrayND} that is backed 
 * by a primitive <code>$type.name$[][]</code> array.
 */
class Array$type.uppercaseName$Array2D 
    extends AbstractMutable$type.uppercaseName$ArrayND 
    implements Mutable$type.uppercaseName$ArrayND
{
    /**
     * The backing array
     */
    private final $type.name$ array[][];

    /**
     * Creates a view on the given array. The array is assumed to be
     * rectangular.
     * 
     * @param array The array
     */
    Array$type.uppercaseName$Array2D($type.name$ array[][])
    {
        super(array.length == 0 ? 
            IntTuples.of(0,0) : 
            IntTuples.of(array.length, array[0].length),
            Order.LEXICOGRAPHICAL);
        this.array = array;
    }

    @Override
    public $type.name$ get(IntTuple coordinates)
    {
        if (coordinates.getSize() != 2)
        {
            throw new IllegalArgumentException(
                "Using "+coordinates.getSize()+"-dimensional " +
                "coordinates for accessing a 2-dimensional array");
        }
        int x = coordinates.get(0);
        int y = coordinates.get(1);
        return array[x][y];
    }

    @Override
    public void set(IntTuple coordinates, $type.name$ value)
    {
        if (coordinates.getSize() != 2)
        {
            throw new IllegalArgumentException(
                "Using "+coordinates.getSize()+"-dimensional " +
                "coordinates for accessing a 2-dimensional array");
        }
        int x = coordinates.get(0);
        int y = coordinates.get(1);
        array[x][y] = value;
    }


}
