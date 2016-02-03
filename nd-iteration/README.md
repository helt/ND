
# nd-iteration

Classes for the iteration over multidimensional ranges. 
classes.  

### Iteration Order

The order of the iteration for tupless can be classified based on the 
dimension of the tuple that varies fastest. Also see [Wikipedia: Lexicographical Order](https://en.wikipedia.org/wiki/Lexicographical_order).  

#### Lexicographical order

Given a tuple, the next tuple in **lexicographical** order is 
computed by incrementing the _rightmost_ element.  In other words, range overflow 
is much like it is known from normal integer number-space:

           099 + 1 =      100 
     (0, 9, 9) + 1 = (1, 0, 0)

For example, the iteration over the range (0,0,0) to (2,2,3) in 
**lexicographical** order is

     (0, 0, 0)
     (0, 0, 1)
     (0, 0, 2)
     (0, 1, 0)
     (0, 1, 1)
     (0, 1, 2)
     (1, 0, 0)
     (1, 0, 1)
     (1, 0, 2)
     (1, 1, 0)
     (1, 1, 1)
     (1, 1, 2)

The iteration over the range (-1,2,-1) to (1,4,2) in 
**lexicographical** order is

     (-1, 2, -1)
     (-1, 2,  0)
     (-1, 2,  1)
     (-1, 3, -1)
     (-1, 3,  0)
     (-1, 3,  1)
     ( 0, 2, -1)
     ( 0, 2,  0)
     ( 0, 2,  1)
     ( 0, 3, -1)
     ( 0, 3,  0)
     ( 0, 3,  1)

#### Colexicographical order

Given an `IntTuple`, the next `IntTuple` in **colexicographical** order 
is computed by incrementing the _leftmost_ element. In case an overflow 
occurs, the next element to the right is incremented. In other words, 
the resulting tuples of a colexicographic iterator are ordered ascending 
from right to left.

          100 + 1 =      010
    (1, 0, 0) + 1 = (0, 1, 0)

and 

           099 + 1 =      199 
     (0, 9, 9) + 1 = (1, 9, 9)





 For example, the iteration over the range (0,0,0) to (2,2,3) in 
**colexicographical** order is

     (0, 0, 0)
     (1, 0, 0)
     (0, 1, 0)
     (1, 1, 0)
     (0, 0, 1)
     (1, 0, 1)
     (0, 1, 1)
     (1, 1, 1)
     (0, 0, 2)
     (1, 0, 2)
     (0, 1, 2)
     (1, 1, 2)

The iteration over the range (-1,2,-1) to (1,4,2) in 
**colexicographical** order is

     (-1, 2, -1)
     ( 0, 2, -1)
     (-1, 3, -1)
     ( 0, 3, -1)
     (-1, 2,  0)
     ( 0, 2,  0)
     (-1, 3,  0)
     ( 0, 3,  0)
     (-1, 2,  1)
     ( 0, 2,  1)
     (-1, 3,  1)
     ( 0, 3,  1)

### Neighborhoods

The `IntTupleNeighborhoodIterables` and
`LongTupleNeighborhoodIterables` class offer iterators over tuples
that describe the neighborhood of a given point. The neighborhoods 
supported here are the **Moore neighborhood** and the 
**Von Neumann neighborhood**.  

#### Moore neighborhood

The **Moore neighborhood** describes all neighbors of a point whose 
Chebyshev distance is not greater than a certain limit:

       2 2 2 2 2 
       2 1 1 1 2 
       2 1 * 1 2
       2 1 1 1 2
       2 2 2 2 2

Also see: [Wikipedia: Moore Neighborhood](https://en.wikipedia.org/wiki/Moore_neighborhood).  

#### Von Neumann neighborhood

The **Von Neumann neighborhood** describes all neighbors of a point whose 
Manhattan distance is not greater than a certain limit:

           2     
         2 1 2   
       2 1 * 1 2
         2 1 2  
           2    

Also see: [Wikipedia: Von Neumann Neighborhood](https://en.wikipedia.org/wiki/Von_Neumann_neighborhood).  
