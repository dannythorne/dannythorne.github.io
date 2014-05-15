
class EdgePositions
{
  class Node
  {
    int n;
    Node x;
    Node y;
    Node z;
    Node( int n0) { n = n0;}

    int xCoord()
    {
      int returnVal=0;
      switch( n)
      {
        case  1: returnVal = 1; break;
        case  2: returnVal = 1; break;
        case  3: returnVal =-1; break;
        case  4: returnVal =-1; break;
        case  5: returnVal = 1; break;
        case  6: returnVal = 1; break;
        case  7: returnVal =-1; break;
        case  8: returnVal =-1; break;
        case  9: returnVal = 0; break;
        case 10: returnVal = 0; break;
        case 11: returnVal = 0; break;
        case 12: returnVal = 0; break;
        default:
          println("xCoord() >> Unhandled case: n = "+n);
          exit();
      }
      return returnVal;
    }

    int yCoord()
    {
      int returnVal=0;
      switch(n)
      {
        case  1: returnVal = 1; break;
        case  2: returnVal =-1; break;
        case  3: returnVal = 1; break;
        case  4: returnVal =-1; break;
        case  5: returnVal = 0; break;
        case  6: returnVal = 0; break;
        case  7: returnVal = 0; break;
        case  8: returnVal = 0; break;
        case  9: returnVal = 1; break;
        case 10: returnVal = 1; break;
        case 11: returnVal =-1; break;
        case 12: returnVal =-1; break;
        default:
          println("yCoord() >> Unhandled case: n = "+n);
          exit();
      }
      return returnVal;
    }

    int zCoord()
    {
      int returnVal=0;
      switch(n)
      {
        case  1: returnVal = 0; break;
        case  2: returnVal = 0; break;
        case  3: returnVal = 0; break;
        case  4: returnVal = 0; break;
        case  5: returnVal = 1; break;
        case  6: returnVal =-1; break;
        case  7: returnVal = 1; break;
        case  8: returnVal =-1; break;
        case  9: returnVal = 1; break;
        case 10: returnVal =-1; break;
        case 11: returnVal = 1; break;
        case 12: returnVal =-1; break;
        default:
          println("zCoord() >> Unhandled case: n = "+n);
          exit();
      }
      return returnVal;
    }
  }

  Node start;

  EdgePositions()
  {
    start = new Node(1);
//                      x   y   z
//                    --- --- ---
//  1  ( 1, 1, 0) -->   6   9   2
    start.x = new Node( 6);
    start.y = new Node( 9);
    start.z = new Node( 2);
//  2  ( 1,-1, 0) -->   5  11   4
    start.z.x = new Node( 5);
    start.z.y = new Node(11);
    start.z.z = new Node( 4);
//  6  ( 1, 0,-1) -->   2   5  12
    start.x.x = start.z;
    start.x.y = start.z.x;
    start.x.z = new Node(12);
//  9  ( 0, 1, 1) -->  10   3   5
    start.y.x = new Node(10);
    start.y.y = new Node( 3);
    start.y.z = start.z.x;
//  3  (-1, 1, 0) -->   8  10   1
    start.y.y.x = new Node( 8);
    start.y.y.y = start.y.x;
    start.y.y.z = start;
//  4  (-1,-1, 0) -->   7  12   3
    start.z.z.x = new Node( 7);
    start.z.z.y = start.x.z;
    start.z.z.z = start.y.y;
//  5  ( 1, 0, 1) -->   1   7  11
    start.z.x.x = start;
    start.z.x.y = start.z.z.x;
    start.z.x.z = start.z.y;
// 10  ( 0, 1,-1) -->  12   1   6
    start.y.x.x = start.x.z;
    start.y.x.y = start;
    start.y.x.z = start.x;
// 11  ( 0,-1, 1) -->   9   4   7
    start.z.y.x = start.y;
    start.z.y.y = start.z.z;
    start.z.y.z = start.z.z.x;
// 12  ( 0,-1,-1) -->  11   2   8
    start.x.z.x = start.z.y;
    start.x.z.y = start.z;
    start.x.z.z = start.y.y.x;
//  7  (-1, 0, 1) -->   3   8   9
    start.z.z.x.x = start.y.y;
    start.z.z.x.y = start.y.y.x;
    start.z.z.x.z = start.y;
//  8  (-1, 0,-1) -->   4   6  10
    start.y.y.x.x = start.z.z;
    start.y.y.x.y = start.x;
    start.y.y.x.z = start.y.x;
  }

//                      xTurn       yTurn       zTurn
//                    ----------  ----------  ----------
//  1  ( 1, 1, 0) --> ( 1, 0,-1); ( 0, 1, 1); ( 1,-1, 0);
//  2  ( 1,-1, 0) --> ( 1, 0, 1); ( 0,-1, 1); (-1,-1, 0);
//  3  (-1, 1, 0) --> (-1, 0,-1); ( 0, 1,-1); ( 1, 1, 0);
//  4  (-1,-1, 0) --> (-1, 0, 1); ( 0,-1,-1); (-1, 1, 0);
//  5  ( 1, 0, 1) --> ( 1, 1, 0); (-1, 0, 1); ( 0,-1, 1);
//  6  ( 1, 0,-1) --> ( 1,-1, 0); ( 1, 0, 1); ( 0,-1,-1);
//  7  (-1, 0, 1) --> (-1, 1, 0); (-1, 0,-1); ( 0, 1, 1);
//  8  (-1, 0,-1) --> (-1,-1, 0); ( 1, 0,-1); ( 0, 1,-1);
//  9  ( 0, 1, 1) --> ( 0, 1,-1); (-1, 1, 0); ( 1, 0, 1);
// 10  ( 0, 1,-1) --> ( 0,-1,-1); ( 1, 1, 0); ( 1, 0,-1);
// 11  ( 0,-1, 1) --> ( 0, 1, 1); (-1,-1, 0); (-1, 0, 1);
// 12  ( 0,-1,-1) --> ( 0,-1, 1); ( 1,-1, 0); (-1, 0,-1);


} // class EdgePositions

class CornerPositions
{
  class Node
  {
    int n;
    Node x;
    Node y;
    Node z;
    Node( int n0) { n = n0;}

    int xCoord()
    {
      int returnVal=0;
      switch(n)
      {
        case  1: returnVal = 1; break;
        case  2: returnVal = 1; break;
        case  3: returnVal = 1; break;
        case  4: returnVal = 1; break;
        case  5: returnVal =-1; break;
        case  6: returnVal =-1; break;
        case  7: returnVal =-1; break;
        case  8: returnVal =-1; break;
        default:
          println("zCooVal =d() >> Unhandled case: n = "+n);
          exit();
      }
      return returnVal;
    }

    int yCoord()
    {
      int returnVal=0;
      switch(n)
      {
        case  1: returnVal = 1; break;
        case  2: returnVal = 1; break;
        case  3: returnVal =-1; break;
        case  4: returnVal =-1; break;
        case  5: returnVal = 1; break;
        case  6: returnVal = 1; break;
        case  7: returnVal =-1; break;
        case  8: returnVal =-1; break;
        default:
          println("zCooVal =d() >> Unhandled case: n = "+n);
          exit();
      }
      return returnVal;
    }

    int zCoord()
    {
      int returnVal=0;
      switch(n)
      {
        case  1: returnVal = 1; break;
        case  2: returnVal =-1; break;
        case  3: returnVal = 1; break;
        case  4: returnVal =-1; break;
        case  5: returnVal = 1; break;
        case  6: returnVal =-1; break;
        case  7: returnVal = 1; break;
        case  8: returnVal =-1; break;
        default:
          println("zCooVal =d() >> Unhandled case: n = "+n);
          exit();
      }
      return returnVal;
    }
  }

  Node start;

  CornerPositions()
  {
    start = new Node(1);
//  1  ( 1, 1, 1) -->   2   5   3
    start.x = new Node(2);
    start.y = new Node(5);
    start.z = new Node(3);
//  2  ( 1, 1,-1) -->   4   1   4
    start.x.x = new Node(4);
    start.x.y = start;
    start.x.z = start.x.x;
//  3  ( 1,-1, 1) -->   1   7   7
    start.z.x = start;
    start.z.y = new Node(7);
    start.z.z = start.z.y;
//  5  (-1, 1, 1) -->   6   6   1
    start.y.x = new Node(6);
    start.y.y = start.y.x;
    start.y.z = start;
//  4  ( 1,-1,-1) -->   3   3   8
    start.x.x.x = start.z;
    start.x.x.y = start.z;
    start.x.x.z = new Node(8);
//  6  (-1, 1,-1) -->   8   2   2
    start.y.x.x = start.x.x.z;
    start.y.x.y = start.x;
    start.y.x.z = start.x;
//  7  (-1,-1, 1) -->   5   8   5
    start.z.y.x = start.y;
    start.z.y.y = start.x.x.z;
    start.z.y.z = start.y;
//  8  (-1,-1,-1) -->   7   4   6
    start.x.x.z.x = start.z.y;
    start.x.x.z.y = start.x.x;
    start.x.x.z.z = start.y.x;
  }

//  1  ( 1, 1, 1) --> ( 1, 1,-1); (-1, 1, 1); ( 1,-1, 1);
//  2  ( 1, 1,-1) --> ( 1,-1,-1); ( 1, 1, 1); ( 1,-1,-1);
//  3  ( 1,-1, 1) --> ( 1, 1, 1); (-1,-1, 1); (-1,-1, 1);
//  4  ( 1,-1,-1) --> ( 1,-1, 1); ( 1,-1, 1); (-1,-1,-1);
//  5  (-1, 1, 1) --> (-1, 1,-1); (-1, 1,-1); ( 1, 1, 1);
//  6  (-1, 1,-1) --> (-1,-1,-1); ( 1, 1,-1); ( 1, 1,-1);
//  7  (-1,-1, 1) --> (-1, 1, 1); (-1,-1,-1); (-1, 1, 1);
//  8  (-1,-1,-1) --> (-1,-1, 1); ( 1,-1,-1); (-1, 1,-1);


} // class CornerPositions

class CenterPositions
{
  class Node
  {
    int n;
    Node x;
    Node y;
    Node z;
    Node( int n0) { n = n0;}

    int xCoord()
    {
      int returnVal=0;
      switch(n)
      {
        case  1: returnVal = 1; break;
        case  2: returnVal =-1; break;
        case  3: returnVal = 0; break;
        case  4: returnVal = 0; break;
        case  5: returnVal = 0; break;
        case  6: returnVal = 0; break;
        default:
          println("xCoord() >> Unhandled case: n = "+n);
          exit();
      }
      return returnVal;
    }

    int yCoord()
    {
      int returnVal=0;
      switch(n)
      {
        case  1: returnVal = 0; break;
        case  2: returnVal = 0; break;
        case  3: returnVal = 1; break;
        case  4: returnVal =-1; break;
        case  5: returnVal = 0; break;
        case  6: returnVal = 0; break;
        default:
          println("yCoord() >> Unhandled case: n = "+n);
          exit();
      }
      return returnVal;
    }

    int zCoord()
    {
      int returnVal=0;
      switch(n)
      {
        case  1: returnVal = 0; break;
        case  2: returnVal = 0; break;
        case  3: returnVal = 0; break;
        case  4: returnVal = 0; break;
        case  5: returnVal = 1; break;
        case  6: returnVal =-1; break;
        default:
          println("zCoord() >> Unhandled case: n = "+n);
          exit();
      }
      return returnVal;
    }
  }

  Node start;

  CenterPositions()
  {
    start = new Node(1);
//  1  ( 1, 0, 0) --> 1 5 4
    start.x = start;
    start.y = new Node(5);
    start.z = new Node(4);
//  5  ( 0, 0, 1) --> 3 2 5
    start.y.x = new Node(3);
    start.y.y = new Node(2);
    start.y.z = start.y;
//  4  ( 0,-1, 0) --> 5 4 2
    start.z.x = start.y;
    start.z.y = start.z;
    start.z.z = start.y.y;
//  3  ( 0, 1, 0) --> 6 3 1
    start.y.x.x = new Node(6);
    start.y.x.y = start.y.x;
    start.y.x.z = start;
//  2  (-1, 0, 0) --> 2 6 3
    start.y.y.x = start.y.y;
    start.y.y.y = start.y.x.x;
    start.y.y.z = start.y.x;
//  6  ( 0, 0,-1) --> 4 1 6
    start.y.x.x.x = start.z;
    start.y.x.x.y = start;
    start.y.x.x.z = start.y.x.x;
  }


}

