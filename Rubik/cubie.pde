
class Cubie
{
  boolean draw_axes;
  Axes axes;
  boolean draw_stickers;
  Stickers stickers;
  boolean draw_cubie;
  float x, y, z;
  int x_turns, y_turns, z_turns;
  int x_turns_prev, y_turns_prev, z_turns_prev;
  float c, dc;
  float tol;
  TurnsGraph turns;
  TurnsGraph.Node curTurn;
  int is_turning;
  boolean is_edge;
  boolean is_corner;
  boolean is_center;
  EdgePositions edgePositions;
  CornerPositions cornerPositions;
  CenterPositions centerPositions;
  EdgePositions.Node edgePos;
  CornerPositions.Node cornerPos;
  CenterPositions.Node centerPos;
  
  Cubie( int init_x, int init_y, int init_z)
  {
    draw_axes = false;
    if( draw_axes) { axes = new Axes();}
    draw_stickers = true;
    if( draw_stickers) { stickers = new Stickers();}
    draw_cubie = true;
    x_turns = y_turns = z_turns = 0;
    x_turns_prev = y_turns_prev = z_turns_prev = 0;
    c = 1;
    dc = .2;
    tol = 1e-3;
    turns = new TurnsGraph();
    curTurn = turns.start;
    is_turning = 0;
    if( abs(init_x)>1 || abs(init_y)>1 || abs(init_z)>1)
    {
      println("ERROR: (init_x,init_y,init_z)=("+init_x+","+init_y+","+init_z+")");
      exit();
    }
    is_edge = false;
    is_corner = false;
    is_center = false;
    if( abs(init_x)+abs(init_y)+abs(init_z)==2)
    {
      is_edge = true;
      edgePositions = new EdgePositions();
      edgePos = edgePositions.start;
      x = edgePos.xCoord();
      y = edgePos.yCoord();
      z = edgePos.zCoord();
      println("(x,y,z)=("+x+","+y+","+z+")");

           if( init_x == 1 && init_y == 1               ) { }
      else if( init_x == 1 && init_y ==-1               ) { edgePos = edgePos.z;}
      else if( init_x ==-1 && init_y == 1               ) { edgePos = edgePos.y.y;}
      else if( init_x ==-1 && init_y ==-1               ) { edgePos = edgePos.z.z;}
      else if( init_x == 1                && init_z == 1) { edgePos = edgePos.x.x.x;}
      else if( init_x == 1                && init_z ==-1) { edgePos = edgePos.x;}
      else if( init_x ==-1                && init_z == 1) { edgePos = edgePos.y.z.z.z;}
      else if( init_x ==-1                && init_z ==-1) { edgePos = edgePos.y.y.x;}
      else if(                init_y == 1 && init_z == 1) { edgePos = edgePos.y;}
      else if(                init_y == 1 && init_z ==-1) { edgePos = edgePos.y.x;}
      else if(                init_y ==-1 && init_z == 1) { edgePos = edgePos.y.x.x.x;}
      else if(                init_y ==-1 && init_z ==-1) { edgePos = edgePos.y.x.x;}
      else
      {
        println("Unhandled case: (init_x,init_y,init_z)=("+init_x+","+init_y+","+init_z+")");
        exit();
      }
      x = edgePos.xCoord();
      y = edgePos.yCoord();
      z = edgePos.zCoord();
      println("(x,y,z)=("+x+","+y+","+z+")");
    }
    else if( abs(init_x)+abs(init_y)+abs(init_z)==3)
    {
      is_corner = true;
      cornerPositions = new CornerPositions();
      cornerPos = cornerPositions.start;
      x = cornerPos.xCoord();
      y = cornerPos.yCoord();
      z = cornerPos.zCoord();
      println("(x,y,z)=("+x+","+y+","+z+")");

           if( init_x == 1 && init_y == 1 && init_z == 1) { }
      else if( init_x == 1 && init_y ==-1 && init_z == 1) { cornerPos = cornerPos.z;}
      else if( init_x ==-1 && init_y == 1 && init_z == 1) { cornerPos = cornerPos.z.z.z;}
      else if( init_x ==-1 && init_y ==-1 && init_z == 1) { cornerPos = cornerPos.z.z;}
      else if( init_x == 1 && init_y == 1 && init_z ==-1) { cornerPos = cornerPos.x;}
      else if( init_x == 1 && init_y ==-1 && init_z ==-1) { cornerPos = cornerPos.x.z;}
      else if( init_x ==-1 && init_y == 1 && init_z ==-1) { cornerPos = cornerPos.x.z.z.z;}
      else if( init_x ==-1 && init_y ==-1 && init_z ==-1) { cornerPos = cornerPos.x.z.z;}
      else
      {
        println("Unhandled case: (init_x,init_y,init_z)=("+init_x+","+init_y+","+init_z+")");
        exit();
      }
      x = cornerPos.xCoord();
      y = cornerPos.yCoord();
      z = cornerPos.zCoord();
      println("(x,y,z)=("+x+","+y+","+z+")");

    }
    else if( abs(init_x)+abs(init_y)+abs(init_z)==1)
    {
      is_center = true;
      centerPositions = new CenterPositions();
      centerPos = centerPositions.start;
      x = centerPos.xCoord();
      y = centerPos.yCoord();
      z = centerPos.zCoord();
      println("(x,y,z)=("+x+","+y+","+z+")");

           if( init_x == 1                              ) { }
      else if( init_x ==-1                              ) { centerPos = centerPos.z.z;}
      else if(                init_y == 1               ) { centerPos = centerPos.z.z.z;}
      else if(                init_y ==-1               ) { centerPos = centerPos.z;}
      else if(                               init_z == 1) { centerPos = centerPos.z.x;}
      else if(                               init_z ==-1) { centerPos = centerPos.z.x.x.x;}
      else
      {
        println("Unhandled case: (init_x,init_y,init_z)=("+init_x+","+init_y+","+init_z+")");
        exit();
      }
      x = centerPos.xCoord();
      y = centerPos.yCoord();
      z = centerPos.zCoord();
      println("(x,y,z)=("+x+","+y+","+z+")");


    }
    else
    {
      println("Unhandled case: (init_x,init_y,init_z)=("+init_x+","+init_y+","+init_z+")");
      exit();
    }
  }
  
  void xTurn()
  {
    println( curTurn.n + " --> " + curTurn.x.n    );
    if( is_turning!=0) { finish_turn();}
    is_turning= 1; c = 0;
  }
  void yTurn()
  {
    println( curTurn.n + " --> " + curTurn.y.n    );
    if( is_turning!=0) { finish_turn();}
    is_turning= 2; c = 0;
  }
  void zTurn()
  {
    println( curTurn.n + " --> " + curTurn.z.n    );
    if( is_turning!=0) { finish_turn();}
    is_turning= 3; c = 0;
  }

  void xTurnBack()
  {
    println( curTurn.n + " --> " + curTurn.x.x.x.n);
    if( is_turning!=0) { finish_turn();}
    is_turning=-1; c = 0;
  }
  void yTurnBack()
  {
    println( curTurn.n + " --> " + curTurn.y.y.y.n);
    if( is_turning!=0) { finish_turn();}
    is_turning=-2; c = 0;
  }
  void zTurnBack()
  {
    println( curTurn.n + " --> " + curTurn.z.z.z.n);
    if( is_turning!=0) { finish_turn();}
    is_turning=-3; c = 0;
  }
  void finish_turn()
  {
    if( abs(is_turning)==1)
    {
      if( is_turning>0)
      {
        curTurn = curTurn.x;
             if( is_edge  ) { edgePos = edgePos.x;}
        else if( is_corner) { cornerPos = cornerPos.x;}
        else if( is_center) { centerPos = centerPos.x;}
        else                { println("ERROR!"); exit();}
      }
      else
      {
        curTurn = curTurn.x.x.x;
             if( is_edge  ) { edgePos = edgePos.x.x.x;}
        else if( is_corner) { cornerPos = cornerPos.x.x.x;}
        else if( is_center) { centerPos = centerPos.x.x.x;}
        else                { println("ERROR!"); exit();}
      }
    }
    else if( abs(is_turning)==2)
    {
      if( is_turning>0)
      {
        curTurn = curTurn.y;
             if( is_edge  ) { edgePos = edgePos.y;}
        else if( is_corner) { cornerPos = cornerPos.y;}
        else if( is_center) { centerPos = centerPos.y;}
        else                { println("ERROR!"); exit();}
      }
      else
      {
        curTurn = curTurn.y.y.y;
             if( is_edge  ) { edgePos = edgePos.y.y.y;}
        else if( is_corner) { cornerPos = cornerPos.y.y.y;}
        else if( is_center) { centerPos = centerPos.y.y.y;}
        else                { println("ERROR!"); exit();}
      }
    }
    else if( abs(is_turning)==3)
    {
      if( is_turning>0)
      {
        curTurn = curTurn.z;
             if( is_edge  ) { edgePos = edgePos.z;}
        else if( is_corner) { cornerPos = cornerPos.z;}
        else if( is_center) { centerPos = centerPos.z;}
        else                { println("ERROR!"); exit();}
      }
      else
      {
        curTurn = curTurn.z.z.z;
             if( is_edge  ) { edgePos = edgePos.z.z.z;}
        else if( is_corner) { cornerPos = cornerPos.z.z.z;}
        else if( is_center) { centerPos = centerPos.z.z.z;}
        else                { println("ERROR!"); exit();}
      }
    }
         if( is_edge  ) { x = edgePos.xCoord();   y = edgePos.yCoord();   z = edgePos.zCoord();  }
    else if( is_corner) { x = cornerPos.xCoord(); y = cornerPos.yCoord(); z = cornerPos.zCoord();}
    else if( is_center) { x = centerPos.xCoord(); y = centerPos.yCoord(); z = centerPos.zCoord();}
    else                { println("ERROR!"); exit();}
  }

  void draw()
  {
    noStroke();
    pushMatrix();
    if( is_turning!=0)
    {
      if( abs(is_turning)==1)
      {
        if( is_turning>0) { rotateX(  c*(PI/2) );} else { rotateX( -c*(PI/2) );}
        translate(x,-y,z);
        if( draw_stickers) { stickers.draw(curTurn);}
        if( c < 1-tol) { c+=dc;} else { c = 1; finish_turn(); is_turning = 0;}
      }
      else if( abs(is_turning)==2)
      {
        if( is_turning>0) { rotateY( -c*(PI/2) );} else { rotateY(  c*(PI/2) );}
        translate(x,-y,z);
        if( draw_stickers) { stickers.draw(curTurn);}
        if( c < 1-tol) { c+=dc;} else { c = 1; finish_turn(); is_turning = 0;}
      }
      else if( abs(is_turning)==3)
      {
        if( is_turning>0) { rotateZ(  c*(PI/2) );} else { rotateZ( -c*(PI/2) );}
        translate(x,-y,z);
        if( draw_stickers) { stickers.draw(curTurn);}
        if( c < 1-tol) { c+=dc;} else { c = 1; finish_turn(); is_turning = 0;}
      }
      else
      {
        println("BOOM!");
        exit();
      }
    }
    else
    {
      translate(x,-y,z);
      if( draw_stickers) { stickers.draw(curTurn);}
    }
    if( draw_axes) { axes.draw();}
    if( draw_cubie) { fill(0); box(1);}
    popMatrix();
  }
}

// ( 0, 0, 0)

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

//  1  ( 1, 1, 1) --> ( 1, 1,-1); (-1, 1, 1); ( 1,-1, 1);
//  2  ( 1, 1,-1) --> ( 1,-1,-1); ( 1, 1, 1); ( 1,-1,-1);
//  3  ( 1,-1, 1) --> ( 1, 1, 1); (-1,-1, 1); (-1,-1, 1);
//  4  ( 1,-1,-1) --> ( 1,-1, 1); ( 1,-1, 1); (-1,-1,-1);
//  5  (-1, 1, 1) --> (-1, 1,-1); (-1, 1,-1); ( 1, 1, 1);
//  6  (-1, 1,-1) --> (-1,-1,-1); ( 1, 1,-1); ( 1, 1,-1);
//  7  (-1,-1, 1) --> (-1, 1, 1); (-1,-1,-1); (-1, 1, 1);
//  8  (-1,-1,-1) --> (-1,-1, 1); ( 1,-1,-1); (-1, 1,-1);

//                      x   y   z
//                    --- --- ---
//  1  ( 1, 1, 0) -->   6   9   2
//  2  ( 1,-1, 0) -->   5  11   4
//  3  (-1, 1, 0) -->   8  10   1
//  4  (-1,-1, 0) -->   7  12   3
//  5  ( 1, 0, 1) -->   1   7  11
//  6  ( 1, 0,-1) -->   2   5  12
//  7  (-1, 0, 1) -->   3   8   9
//  8  (-1, 0,-1) -->   4   6  10
//  9  ( 0, 1, 1) -->  10   3   5
// 10  ( 0, 1,-1) -->  12   1   6
// 11  ( 0,-1, 1) -->   9   4   7
// 12  ( 0,-1,-1) -->  11   2   8

//  1  ( 1, 1, 1) -->   2   5   3
//  2  ( 1, 1,-1) -->   4   1   4
//  3  ( 1,-1, 1) -->   1   7   7
//  4  ( 1,-1,-1) -->   3   3   8
//  5  (-1, 1, 1) -->   6   6   1
//  6  (-1, 1,-1) -->   8   2   2
//  7  (-1,-1, 1) -->   5   8   5
//  8  (-1,-1,-1) -->   7   4   6






