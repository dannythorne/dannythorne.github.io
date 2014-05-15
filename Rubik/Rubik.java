import processing.core.*; import java.applet.*; import java.awt.*; import java.awt.image.*; import java.awt.event.*; import java.io.*; import java.net.*; import java.text.*; import java.util.*; import java.util.zip.*; public class Rubik extends PApplet {


class Axes
{
  float m_width, m_length;
  int m_alpha;
  Axes()
  {
    m_width=.1f;
    m_length=20;
    m_alpha = 255;
  }
  Axes( float init_width, float init_length, int init_alpha)
  {
    m_width=init_width;
    m_length=init_length;
    m_alpha=init_alpha;
  }
  public void draw()
  {
    pushMatrix();
    translate(m_length/4,0,0);
    fill(192,0,0,m_alpha);
    box(m_length/2, m_width, m_width);
    popMatrix();

    pushMatrix();
    translate(0,-m_length/4,0);
    fill(0,192,0,m_alpha);
    box( m_width,m_length/2, m_width);
    popMatrix();

    pushMatrix();
    translate(0,0,m_length/4);
    fill(0,0,192,m_alpha);
    box( m_width, m_width,m_length/2);
    popMatrix();

    pushMatrix();
    translate(-m_length/4,0,0);
    fill(0,192,192,m_alpha);
    box(m_length/2, m_width, m_width);
    popMatrix();

    pushMatrix();
    translate(0,m_length/4,0);
    fill(192,0,192,m_alpha);
    box( m_width,m_length/2, m_width);
    popMatrix();

    pushMatrix();
    translate(0,0,-m_length/4);
    fill(192,192,0,m_alpha);
    box( m_width, m_width,m_length/2);
    popMatrix();
  }
}





class Cube
{
  Cubie ru, rd;
  Cubie lu, ld;
  Cubie uf, df;
  Cubie ub, db;
  Cubie rf, rb;
  Cubie lf, lb;
  
  Cubie ruf, rub, rdf, rdb;
  Cubie luf, lub, ldf, ldb;

  Cubie r, l, u, d, f, b;

  Cube()
  {
    ru = new Cubie( 1, 1, 0);
    rd = new Cubie( 1,-1, 0);
    lu = new Cubie(-1, 1, 0);
    ld = new Cubie(-1,-1, 0);
    uf = new Cubie( 0, 1, 1);
    df = new Cubie( 0,-1, 1);
    ub = new Cubie( 0, 1,-1);
    db = new Cubie( 0,-1,-1);
    rf = new Cubie( 1, 0, 1);
    rb = new Cubie( 1, 0,-1);
    lf = new Cubie(-1, 0, 1);
    lb = new Cubie(-1, 0,-1);
    
    ruf = new Cubie( 1, 1, 1);
    rub = new Cubie( 1, 1,-1);
    rdf = new Cubie( 1,-1, 1);
    rdb = new Cubie( 1,-1,-1);
    luf = new Cubie(-1, 1, 1);
    lub = new Cubie(-1, 1,-1);
    ldf = new Cubie(-1,-1, 1);
    ldb = new Cubie(-1,-1,-1);

    r = new Cubie( 1, 0, 0);
    l = new Cubie(-1, 0, 0);
    u = new Cubie( 0, 1, 0);
    d = new Cubie( 0,-1, 0);
    f = new Cubie( 0, 0, 1);
    b = new Cubie( 0, 0,-1);
  }

  public void draw()
  {
    ru.draw(); rd.draw(); lu.draw(); ld.draw();
    uf.draw(); df.draw(); ub.draw(); db.draw();
    rf.draw(); rb.draw(); lf.draw(); lb.draw();
    
    ruf.draw(); rub.draw(); rdf.draw(); rdb.draw();
    luf.draw(); lub.draw(); ldf.draw(); ldb.draw();

    r.draw(); l.draw(); u.draw(); d.draw(); f.draw(); b.draw();
  }

  public void xTurn()
  {  ru.xTurn();  rd.xTurn();  lu.xTurn();  ld.xTurn();     
     uf.xTurn();  df.xTurn();  ub.xTurn();  db.xTurn();     
     rf.xTurn();  rb.xTurn();  lf.xTurn();  lb.xTurn();     
    ruf.xTurn(); rub.xTurn(); rdf.xTurn(); rdb.xTurn();     
    luf.xTurn(); lub.xTurn(); ldf.xTurn(); ldb.xTurn();     
      r.xTurn();   l.xTurn();
      u.xTurn();   d.xTurn();
      f.xTurn();   b.xTurn();
    Cubie temp = ru;   ru = rf;   rf = rd;   rd = rb;   rb = temp;
          temp = ruf; ruf = rdf; rdf = rdb; rdb = rub; rub = temp;
          temp = lu;   lu = lf;   lf = ld;   ld = lb;   lb = temp;
          temp = luf; luf = ldf; ldf = ldb; ldb = lub; lub = temp;
          temp = uf;   uf = df;   df = db;   db = ub;   ub = temp;
          temp = f;     f = d;     d = b;     b = u;     u = temp;
  }
  public void yTurn()
  {  ru.yTurn();  rd.yTurn();  lu.yTurn();  ld.yTurn();
     uf.yTurn();  df.yTurn();  ub.yTurn();  db.yTurn();
     rf.yTurn();  rb.yTurn();  lf.yTurn();  lb.yTurn();
    ruf.yTurn(); rub.yTurn(); rdf.yTurn(); rdb.yTurn();
    luf.yTurn(); lub.yTurn(); ldf.yTurn(); ldb.yTurn();
      r.yTurn();   l.yTurn();
      u.yTurn();   d.yTurn();
      f.yTurn();   b.yTurn();
    Cubie temp = ru;   ru = ub;   ub = lu;   lu = uf;   uf = temp;
          temp = ruf; ruf = rub; rub = lub; lub = luf; luf = temp;
          temp = rd;   rd = db;   db = ld;   ld = df;   df = temp;
          temp = rdf; rdf = rdb; rdb = ldb; ldb = ldf; ldf = temp;
          temp = rf;   rf = rb;   rb = lb;   lb = lf;   lf = temp;
          temp = r;     r = b;     b = l;     l = f;     f = temp;
  }
  public void zTurn()
  {  ru.zTurn();  rd.zTurn();  lu.zTurn();  ld.zTurn();
     uf.zTurn();  df.zTurn();  ub.zTurn();  db.zTurn();
     rf.zTurn();  rb.zTurn();  lf.zTurn();  lb.zTurn();
    ruf.zTurn(); rub.zTurn(); rdf.zTurn(); rdb.zTurn();
    luf.zTurn(); lub.zTurn(); ldf.zTurn(); ldb.zTurn();
      r.zTurn();   l.zTurn();
      u.zTurn();   d.zTurn();
      f.zTurn();   b.zTurn();
    Cubie temp = uf;   uf = lf;   lf = df;   df = rf;   rf = temp;
          temp = ruf; ruf = luf; luf = ldf; ldf = rdf; rdf = temp;
          temp = ub;   ub = lb;   lb = db;   db = rb;   rb = temp;
          temp = rub; rub = lub; lub = ldb; ldb = rdb; rdb = temp;
          temp = ru; ru = lu; lu = ld; ld = rd; rd = temp;
          temp = r;   r = u;   u = l;   l = d;   d = temp;
  }
  public void xTurnBack()
  {  ru.xTurnBack();  rd.xTurnBack();  lu.xTurnBack();  ld.xTurnBack();
     uf.xTurnBack();  df.xTurnBack();  ub.xTurnBack();  db.xTurnBack();
     rf.xTurnBack();  rb.xTurnBack();  lf.xTurnBack();  lb.xTurnBack();
    ruf.xTurnBack(); rub.xTurnBack(); rdf.xTurnBack(); rdb.xTurnBack();
    luf.xTurnBack(); lub.xTurnBack(); ldf.xTurnBack(); ldb.xTurnBack();
      r.xTurnBack();   l.xTurnBack();
      u.xTurnBack();   d.xTurnBack();
      f.xTurnBack();   b.xTurnBack();
    Cubie temp = lu;   lu = lb;   lb = ld;   ld = lf;   lf = temp;
          temp = luf; luf = lub; lub = ldb; ldb = ldf; ldf = temp;
          temp = ru;   ru = rb;   rb = rd;   rd = rf;   rf = temp;
          temp = ruf; ruf = rub; rub = rdb; rdb = rdf; rdf = temp;
          temp = uf; uf = ub; ub = db; db = df; df = temp;
          temp = f;   f = u;   u = b;   b = d;   d = temp;
  }
  public void yTurnBack()
  {  ru.yTurnBack();  rd.yTurnBack();  lu.yTurnBack();  ld.yTurnBack();
     uf.yTurnBack();  df.yTurnBack();  ub.yTurnBack();  db.yTurnBack();
     rf.yTurnBack();  rb.yTurnBack();  lf.yTurnBack();  lb.yTurnBack();
    ruf.yTurnBack(); rub.yTurnBack(); rdf.yTurnBack(); rdb.yTurnBack();
    luf.yTurnBack(); lub.yTurnBack(); ldf.yTurnBack(); ldb.yTurnBack();
      r.yTurnBack();   l.yTurnBack();
      u.yTurnBack();   d.yTurnBack();
      f.yTurnBack();   b.yTurnBack();
    Cubie temp = ru;   ru = uf;   uf = lu;   lu = ub;   ub = temp;
          temp = ruf; ruf = luf; luf = lub; lub = rub; rub = temp;
          temp = rd;   rd = df;   df = ld;   ld = db;   db = temp;
          temp = rdf; rdf = ldf; ldf = ldb; ldb = rdb; rdb = temp;
          temp = rf;   rf = lf;   lf = lb;   lb = rb;   rb = temp;
          temp = r;     r = f;     f = l;     l = b;     b = temp;
  }
  public void zTurnBack()
  {  ru.zTurnBack();  rd.zTurnBack();  lu.zTurnBack();  ld.zTurnBack();
     uf.zTurnBack();  df.zTurnBack();  ub.zTurnBack();  db.zTurnBack();
     rf.zTurnBack();  rb.zTurnBack();  lf.zTurnBack();  lb.zTurnBack();
    ruf.zTurnBack(); rub.zTurnBack(); rdf.zTurnBack(); rdb.zTurnBack();
    luf.zTurnBack(); lub.zTurnBack(); ldf.zTurnBack(); ldb.zTurnBack();
      r.zTurnBack();   l.zTurnBack();
      u.zTurnBack();   d.zTurnBack();
      f.zTurnBack();   b.zTurnBack();
    Cubie temp = uf;   uf = rf;   rf = df;   df = lf;   lf = temp;
          temp = ruf; ruf = rdf; rdf = ldf; ldf = luf; luf = temp;
          temp = ub;   ub = rb;   rb = db;   db = lb;   lb = temp;
          temp = rub; rub = rdb; rdb = ldb; ldb = lub; lub = temp;
          temp = ru;   ru = rd;   rd = ld;   ld = lu;   lu = temp;
          temp = r;     r = d;     d = l;     l = u;     u = temp;
  }

  public void rTurn()
  { ru.xTurn(); rd.xTurn(); rf.xTurn(); rb.xTurn(); ruf.xTurn(); rub.xTurn(); rdf.xTurn(); rdb.xTurn(); r.xTurn();
    Cubie temp = ru;   ru = rf;   rf = rd;   rd = rb;   rb = temp;
          temp = ruf; ruf = rdf; rdf = rdb; rdb = rub; rub = temp; }
  public void rTurnBack()
  { ru.xTurnBack(); rd.xTurnBack(); rf.xTurnBack(); rb.xTurnBack(); ruf.xTurnBack(); rub.xTurnBack(); rdf.xTurnBack(); rdb.xTurnBack(); r.xTurnBack();
    Cubie temp = ru;   ru = rb;   rb = rd;   rd = rf;   rf = temp;
          temp = ruf; ruf = rub; rub = rdb; rdb = rdf; rdf = temp; }
  public void mrTurn()
  { uf.xTurn(); df.xTurn(); ub.xTurn(); db.xTurn(); u.xTurn(); d.xTurn(); f.xTurn(); b.xTurn();
    Cubie temp = uf; uf = df; df = db; db = ub; ub = temp;
          temp = f;   f = d;   d = b;   b = u;   u = temp; }

  public void lTurn()
  { lu.xTurnBack(); ld.xTurnBack(); lf.xTurnBack(); lb.xTurnBack(); luf.xTurnBack(); lub.xTurnBack(); ldf.xTurnBack(); ldb.xTurnBack(); l.xTurnBack();
    Cubie temp = lu;   lu = lb;   lb = ld;   ld = lf;   lf = temp;
          temp = luf; luf = lub; lub = ldb; ldb = ldf; ldf = temp; }
  public void lTurnBack()
  { lu.xTurn(); ld.xTurn(); lf.xTurn(); lb.xTurn(); luf.xTurn(); lub.xTurn(); ldf.xTurn(); ldb.xTurn(); l.xTurn();
    Cubie temp = lu;   lu = lf;   lf = ld;   ld = lb;   lb = temp;
          temp = luf; luf = ldf; ldf = ldb; ldb = lub; lub = temp; }
  public void mlTurn()
  { uf.xTurnBack(); df.xTurnBack(); ub.xTurnBack(); db.xTurnBack(); u.xTurnBack(); d.xTurnBack(); f.xTurnBack(); b.xTurnBack();
    Cubie temp = uf; uf = ub; ub = db; db = df; df = temp;
          temp = f;   f = u;   u = b;   b = d;   d = temp; }

  public void uTurn()
  { ru.yTurn(); lu.yTurn(); uf.yTurn(); ub.yTurn(); ruf.yTurn(); rub.yTurn(); luf.yTurn(); lub.yTurn(); u.yTurn();
    Cubie temp = ru;   ru = ub;   ub = lu;   lu = uf;   uf = temp;
          temp = ruf; ruf = rub; rub = lub; lub = luf; luf = temp; }
  public void uTurnBack()
  { ru.yTurnBack(); lu.yTurnBack(); uf.yTurnBack(); ub.yTurnBack(); ruf.yTurnBack(); rub.yTurnBack(); luf.yTurnBack(); lub.yTurnBack(); u.yTurnBack();
    Cubie temp = ru;   ru = uf;   uf = lu;   lu = ub;   ub = temp;
          temp = ruf; ruf = luf; luf = lub; lub = rub; rub = temp; }
  public void muTurn()
  { rf.yTurn(); rb.yTurn(); lf.yTurn(); lb.yTurn(); r.yTurn(); l.yTurn(); f.yTurn(); b.yTurn();
    Cubie temp = rf; rf = rb; rb = lb; lb = lf; lf = temp;
          temp = r;   r = b;   b = l;   l = f;   f = temp; }

  public void dTurn()
  { rd.yTurnBack(); ld.yTurnBack(); df.yTurnBack(); db.yTurnBack(); rdf.yTurnBack(); rdb.yTurnBack(); ldf.yTurnBack(); ldb.yTurnBack(); d.yTurnBack();
    Cubie temp = rd;   rd = df;   df = ld;   ld = db;   db = temp;
          temp = rdf; rdf = ldf; ldf = ldb; ldb = rdb; rdb = temp; }
  public void dTurnBack()
  { rd.yTurn(); ld.yTurn(); df.yTurn(); db.yTurn(); rdf.yTurn(); rdb.yTurn(); ldf.yTurn(); ldb.yTurn(); d.yTurn();
    Cubie temp = rd;   rd = db;   db = ld;   ld = df;   df = temp;
          temp = rdf; rdf = rdb; rdb = ldb; ldb = ldf; ldf = temp; }
  public void mdTurn()
  { rf.yTurnBack(); rb.yTurnBack(); lf.yTurnBack(); lb.yTurnBack(); r.yTurnBack(); l.yTurnBack(); f.yTurnBack(); b.yTurnBack();
    Cubie temp = rf; rf = lf; lf = lb; lb = rb; rb = temp;
          temp = r;   r = f;   f = l;   l = b;   b = temp; }

  public void fTurn()
  { uf.zTurn(); df.zTurn(); rf.zTurn(); lf.zTurn(); ruf.zTurn(); rdf.zTurn(); luf.zTurn(); ldf.zTurn(); f.zTurn();
    Cubie temp = uf;   uf = lf;   lf = df;   df = rf;   rf = temp;
          temp = ruf; ruf = luf; luf = ldf; ldf = rdf; rdf = temp; }
  public void fTurnBack()
  { uf.zTurnBack(); df.zTurnBack(); rf.zTurnBack(); lf.zTurnBack(); ruf.zTurnBack(); rdf.zTurnBack(); luf.zTurnBack(); ldf.zTurnBack(); f.zTurnBack();
    Cubie temp = uf;   uf = rf;   rf = df;   df = lf;   lf = temp;
          temp = ruf; ruf = rdf; rdf = ldf; ldf = luf; luf = temp; }
  public void mfTurn()
  { ru.zTurn(); rd.zTurn(); lu.zTurn(); ld.zTurn(); r.zTurn(); l.zTurn(); u.zTurn(); d.zTurn();
    Cubie temp = ru; ru = lu; lu = ld; ld = rd; rd = temp;
          temp = r;   r = u;   u = l;   l = d;   d = temp; }

  public void bTurn()
  { ub.zTurnBack(); db.zTurnBack(); rb.zTurnBack(); lb.zTurnBack(); rub.zTurnBack(); rdb.zTurnBack(); lub.zTurnBack(); ldb.zTurnBack(); b.zTurnBack();
    Cubie temp = ub;   ub = rb;   rb = db;   db = lb;   lb = temp;
          temp = rub; rub = rdb; rdb = ldb; ldb = lub; lub = temp; }
  public void bTurnBack()
  { ub.zTurn(); db.zTurn(); rb.zTurn(); lb.zTurn(); rub.zTurn(); rdb.zTurn(); lub.zTurn(); ldb.zTurn(); b.zTurn();
    Cubie temp = ub;   ub = lb;   lb = db;   db = rb;   rb = temp;
          temp = rub; rub = lub; lub = ldb; ldb = rdb; rdb = temp; }
  public void mbTurn()
  { ru.zTurnBack(); rd.zTurnBack(); lu.zTurnBack(); ld.zTurnBack(); r.zTurnBack(); l.zTurnBack(); u.zTurnBack(); d.zTurnBack();
    Cubie temp = ru; ru = rd; rd = ld; ld = lu; lu = temp;
          temp = r;   r = d;   d = l;   l = u;   u = temp; }


}







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
    dc = .2f;
    tol = 1e-3f;
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
  
  public void xTurn()
  {
    println( curTurn.n + " --> " + curTurn.x.n    );
    if( is_turning!=0) { finish_turn();}
    is_turning= 1; c = 0;
  }
  public void yTurn()
  {
    println( curTurn.n + " --> " + curTurn.y.n    );
    if( is_turning!=0) { finish_turn();}
    is_turning= 2; c = 0;
  }
  public void zTurn()
  {
    println( curTurn.n + " --> " + curTurn.z.n    );
    if( is_turning!=0) { finish_turn();}
    is_turning= 3; c = 0;
  }

  public void xTurnBack()
  {
    println( curTurn.n + " --> " + curTurn.x.x.x.n);
    if( is_turning!=0) { finish_turn();}
    is_turning=-1; c = 0;
  }
  public void yTurnBack()
  {
    println( curTurn.n + " --> " + curTurn.y.y.y.n);
    if( is_turning!=0) { finish_turn();}
    is_turning=-2; c = 0;
  }
  public void zTurnBack()
  {
    println( curTurn.n + " --> " + curTurn.z.z.z.n);
    if( is_turning!=0) { finish_turn();}
    is_turning=-3; c = 0;
  }
  public void finish_turn()
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

  public void draw()
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








class History
{
  class Node
  {
    int n;
    Node next;
    Node prev;
    Node( int n0)
    {
      n = n0;
      next = null;
      prev = null;
    }
  }

  Node head;
  Node tail;

  History() { head = new Node(-1); tail = head;}

  public void push( int n)
  {
    if( tail.next == null)
    {
      tail.next = new Node(n);
      tail.next.prev = tail;
    }
    tail = tail.next;
    tail.n = n;
  }

  public boolean push()
  {
    if( tail.next != null) { tail = tail.next; return true;}
    return false;
  }

  public void pop()
  {
    if( tail != head)
    {
      tail = tail.prev;
    }
  }

  public int top() { return tail.n;}

  public void draw()
  {
    stroke(255);
    fill(255);
    //textAlign(CENTER);
    textAlign(LEFT);
    int x;
    int dx = 18;

    Node cur = tail;
    if( cur==head) { cur=cur.next; fill(192);} else { fill(0);}
    x = round((.67f)*width);
    while( cur != null)
    {
      textFont(font,24);
      switch( cur.n)
      {
        case  1: text("r",x,24);  /* x+=.8*dx;  */ break;
        case  2: text("R",x,24);  /* x+=dx;     */ break;
        case  3: text("l",x,24);  /* x+=.5*dx;  */ break;
        case  4: text("L",x,24);  /* x+=dx;     */ break;
        case  5: text("u",x,24);  /* x+=.8*dx;  */ break;
        case  6: text("U",x,24);  /* x+=dx;     */ break;
        case  7: text("d",x,24);  /* x+=.8*dx;  */ break;
        case  8: text("D",x,24);  /* x+=dx;     */ break;
        case  9: text("f",x,24);  /* x+=.5*dx;  */ break;
        case 10: text("F",x,24);  /* x+=dx;     */ break;
        case 11: text("b",x,24);  /* x+=.8*dx;  */ break;
        case 12: text("B",x,24);  /* x+=dx;     */ break;
        case 13: text("x",x,24);  /* x+=.8*dx;  */ break;
        case 14: text("y",x,24);  /* x+=.8*dx;  */ break;
        case 15: text("z",x,24);  /* x+=.8*dx;  */ break;
        case 16: text("X",x,24);  /* x+=dx;     */ break;
        case 17: text("Y",x,24);  /* x+=dx;     */ break;
        case 18: text("Z",x,24);  /* x+=dx;     */ break;
        case 19: text("m",x,24); x+=.9f*dx; textFont(font,18); text("r",x,24+8); /* x+=1.67*dx;*/ break;
        case 20: text("m",x,24); x+=.9f*dx; textFont(font,18); text("l",x,24+8); /* x+=1.67*dx;*/ break;
        case 21: text("m",x,24); x+=.9f*dx; textFont(font,18); text("u",x,24+8); /* x+=1.67*dx;*/ break;
        case 22: text("m",x,24); x+=.9f*dx; textFont(font,18); text("d",x,24+8); /* x+=2*dx;   */ break;
        case 23: text("m",x,24); x+=.9f*dx; textFont(font,18); text("f",x,24+8); /* x+=1.67*dx;*/ break;
        case 24: text("m",x,24); x+=.9f*dx; textFont(font,18); text("b",x,24+8); /* x+=1.67*dx;*/ break;
        default: println("Unhandled case: cur.n = " + cur.n); exit();
      }
      cur = cur.next;
      x += dx;
      fill(192);
    }

    cur = tail.prev;
    x = round((.67f)*width) - dx;
    fill(255);
    while( cur != head && cur != null)
    {
      textFont(font,24);
      switch( cur.n)
      {
        case  1: text("r",x,24);  /* x+=.8*dx;  */ break;
        case  2: text("R",x,24);  /* x+=dx;     */ break;
        case  3: text("l",x,24);  /* x+=.5*dx;  */ break;
        case  4: text("L",x,24);  /* x+=dx;     */ break;
        case  5: text("u",x,24);  /* x+=.8*dx;  */ break;
        case  6: text("U",x,24);  /* x+=dx;     */ break;
        case  7: text("d",x,24);  /* x+=.8*dx;  */ break;
        case  8: text("D",x,24);  /* x+=dx;     */ break;
        case  9: text("f",x,24);  /* x+=.5*dx;  */ break;
        case 10: text("F",x,24);  /* x+=dx;     */ break;
        case 11: text("b",x,24);  /* x+=.8*dx;  */ break;
        case 12: text("B",x,24);  /* x+=dx;     */ break;
        case 13: text("x",x,24);  /* x+=.8*dx;  */ break;
        case 14: text("y",x,24);  /* x+=.8*dx;  */ break;
        case 15: text("z",x,24);  /* x+=.8*dx;  */ break;
        case 16: text("X",x,24);  /* x+=dx;     */ break;
        case 17: text("Y",x,24);  /* x+=dx;     */ break;
        case 18: text("Z",x,24);  /* x+=dx;     */ break;
        case 19: x-=.9f*dx; text("m",x,24); x+=.9f*dx; textFont(font,18); text("r",x,24+8); x-=.9f*dx; /* x+=1.67*dx;*/ break;
        case 20: x-=.9f*dx; text("m",x,24); x+=.9f*dx; textFont(font,18); text("l",x,24+8); x-=.9f*dx; /* x+=1.67*dx;*/ break;
        case 21: x-=.9f*dx; text("m",x,24); x+=.9f*dx; textFont(font,18); text("u",x,24+8); x-=.9f*dx; /* x+=1.67*dx;*/ break;
        case 22: x-=.9f*dx; text("m",x,24); x+=.9f*dx; textFont(font,18); text("d",x,24+8); x-=.9f*dx; /* x+=2*dx;   */ break;
        case 23: x-=.9f*dx; text("m",x,24); x+=.9f*dx; textFont(font,18); text("f",x,24+8); x-=.9f*dx; /* x+=1.67*dx;*/ break;
        case 24: x-=.9f*dx; text("m",x,24); x+=.9f*dx; textFont(font,18); text("b",x,24+8); x-=.9f*dx; /* x+=1.67*dx;*/ break;
        default: println("Unhandled case: cur.n = " + cur.n); exit();
      }
      cur = cur.prev;
      x -= dx;
    }
  }

} // class History





class EdgePositions
{
  class Node
  {
    int n;
    Node x;
    Node y;
    Node z;
    Node( int n0) { n = n0;}

    public int xCoord()
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

    public int yCoord()
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

    public int zCoord()
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

    public int xCoord()
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

    public int yCoord()
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

    public int zCoord()
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

    public int xCoord()
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

    public int yCoord()
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

    public int zCoord()
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


//import processing.opengl.*;

float s; // scale factor
float px, py; // perspective
boolean shift_is_on;
boolean middle;
boolean Middle;

//Cubie cube;
Cube cube;
Axes axes = new Axes(.05f,200,255);

History history;

PFont font;

public void setup()
{
  size(400,400,P3D);
  frameRate(15);

  s = 64;

  px = -PI/7;
  py = -PI/5;

  shift_is_on = false;
  middle = false;
  Middle = false;

  //cube = new Cubie(1,1,1);
  cube = new Cube();

  history = new History();

  //font = loadFont("ArialMT-24.vlw");
  font = loadFont("Courier-24.vlw");

}

public void draw()
{
  background(0xffddddcc);

  pushMatrix();
  history.draw();

  translate(width/2,height/2,0);
  scale(s);
  lights();
  rotateX(px);
  rotateY(py);

  noStroke();
  //axes.draw();

  cube.draw();

  popMatrix();
}

public void keyPressed()
{
  if( key==CODED)
  {
    switch(keyCode)
    {
      case SHIFT: shift_is_on = true; break;
      default: println("Unhandled keyCode ("+keyCode+") pressed. (key='"+key+"')");
    }
  }
  else
  {
    switch(key)
    {
      case 'r': if( middle || Middle) { cube.mrTurn(); history.push(19); middle=false;} else { cube.rTurn();     history.push( 1);} break;
      case 'R': if( middle || Middle) { cube.mlTurn(); history.push(20); middle=false;} else { cube.rTurnBack(); history.push( 2);} break;
      case 'l': if( middle || Middle) { cube.mlTurn(); history.push(20); middle=false;} else { cube.lTurn();     history.push( 3);} break;
      case 'L': if( middle || Middle) { cube.mrTurn(); history.push(19); middle=false;} else { cube.lTurnBack(); history.push( 4);} break;
      case 'u': if( middle || Middle) { cube.muTurn(); history.push(21); middle=false;} else { cube.uTurn();     history.push( 5);} break;
      case 'U': if( middle || Middle) { cube.mdTurn(); history.push(22); middle=false;} else { cube.uTurnBack(); history.push( 6);} break;
      case 'd': if( middle || Middle) { cube.mdTurn(); history.push(22); middle=false;} else { cube.dTurn();     history.push( 7);} break;
      case 'D': if( middle || Middle) { cube.muTurn(); history.push(21); middle=false;} else { cube.dTurnBack(); history.push( 8);} break;
      case 'f': if( middle || Middle) { cube.mfTurn(); history.push(23); middle=false;} else { cube.fTurn();     history.push( 9);} break;
      case 'F': if( middle || Middle) { cube.mbTurn(); history.push(24); middle=false;} else { cube.fTurnBack(); history.push(10);} break;
      case 'b': if( middle || Middle) { cube.mbTurn(); history.push(24); middle=false;} else { cube.bTurn();     history.push(11);} break;
      case 'B': if( middle || Middle) { cube.mfTurn(); history.push(23); middle=false;} else { cube.bTurnBack(); history.push(12);} break;
      case 'm': middle = true;    break;
      case 'M': Middle = !Middle; break;
      case 'x': cube.xTurn();     history.push(13); break;
      case 'y': cube.yTurn();     history.push(14); break;
      case 'z': cube.zTurn();     history.push(15); break;
      case 'X': cube.xTurnBack(); history.push(16); break;
      case 'Y': cube.yTurnBack(); history.push(17); break;
      case 'Z': cube.zTurnBack(); history.push(18); break;
      case 's':
        switch(PApplet.parseInt(random(0,23)))
        {
          case  0: cube.rTurn();     history.push( 1); break;
          case  1: cube.rTurnBack(); history.push( 2); break;
          case  2: cube.lTurn();     history.push( 3); break;
          case  3: cube.lTurnBack(); history.push( 4); break;
          case  4: cube.uTurn();     history.push( 5); break;
          case  5: cube.uTurnBack(); history.push( 6); break;
          case  6: cube.dTurn();     history.push( 7); break;
          case  7: cube.dTurnBack(); history.push( 8); break;
          case  8: cube.fTurn();     history.push( 9); break;
          case  9: cube.fTurnBack(); history.push(10); break;
          case 10: cube.bTurn();     history.push(11); break;
          case 11: cube.bTurnBack(); history.push(12); break;
          case 12: cube.xTurn();     history.push(13); break;
          case 13: cube.yTurn();     history.push(14); break;
          case 14: cube.zTurn();     history.push(15); break;
          case 15: cube.xTurnBack(); history.push(16); break;
          case 16: cube.yTurnBack(); history.push(17); break;
          case 17: cube.zTurnBack(); history.push(18); break;
          case 18: cube.mrTurn();    history.push(19);break;
          case 19: cube.mlTurn();    history.push(20);break;
          case 20: cube.muTurn();    history.push(21);break;
          case 21: cube.mdTurn();    history.push(22);break;
          case 22: cube.mfTurn();    history.push(23);break;
          case 23: cube.mbTurn();    history.push(24);break;
          default: println("Unhandled case: int(random())"); exit();
        }
        break;
      case ' ': if( shift_is_on) { s/=1.1f;} else { s*=1.1f;} break;
      case DELETE:
      case BACKSPACE:
        switch(history.top())
        {
          case -1: break;
          case  1: cube.rTurnBack(); break;
          case  2: cube.rTurn();     break;
          case  3: cube.lTurnBack(); break;
          case  4: cube.lTurn();     break;
          case  5: cube.uTurnBack(); break;
          case  6: cube.uTurn();     break;
          case  7: cube.dTurnBack(); break;
          case  8: cube.dTurn();     break;
          case  9: cube.fTurnBack(); break;
          case 10: cube.fTurn();     break;
          case 11: cube.bTurnBack(); break;
          case 12: cube.bTurn();     break;
          case 13: cube.xTurnBack(); break;
          case 14: cube.yTurnBack(); break;
          case 15: cube.zTurnBack(); break;
          case 16: cube.xTurn();     break;
          case 17: cube.yTurn();     break;
          case 18: cube.zTurn();     break;
          case 19: cube.mlTurn();    break;
          case 20: cube.mrTurn();    break;
          case 21: cube.mdTurn();    break;
          case 22: cube.muTurn();    break;
          case 23: cube.mbTurn();    break;
          case 24: cube.mfTurn();    break;
          default: println("Unhandled case: history.top() = " + history.top()); exit();
        }
        history.pop();
        break;
      case TAB:
        if( history.push())
        {
          switch(history.top())
          {
            case -1: break;
            case  1: cube.rTurn(); break;
            case  2: cube.rTurnBack();     break;
            case  3: cube.lTurn(); break;
            case  4: cube.lTurnBack();     break;
            case  5: cube.uTurn(); break;
            case  6: cube.uTurnBack();     break;
            case  7: cube.dTurn(); break;
            case  8: cube.dTurnBack();     break;
            case  9: cube.fTurn(); break;
            case 10: cube.fTurnBack();     break;
            case 11: cube.bTurn(); break;
            case 12: cube.bTurnBack();     break;
            case 13: cube.xTurn(); break;
            case 14: cube.yTurn(); break;
            case 15: cube.zTurn(); break;
            case 16: cube.xTurnBack();     break;
            case 17: cube.yTurnBack();     break;
            case 18: cube.zTurnBack();     break;
            case 19: cube.mrTurn();    break;
            case 20: cube.mlTurn();    break;
            case 21: cube.muTurn();    break;
            case 22: cube.mdTurn();    break;
            case 23: cube.mfTurn();    break;
            case 24: cube.mbTurn();    break;
            default: println("Unhandled case: history.top() = " + history.top()); exit();
          }
        }
        break;

      default: println("Unhandled key '"+key+"' pressed.");
    }
  }
}

public void keyReleased()
{
  if( key==CODED)
  {
    switch(keyCode)
    {
      case SHIFT: shift_is_on = false; break;
      default: println("Unhandled keyCode ("+keyCode+") released.");
    }
  }
  else
  {
    switch(key)
    {
      default: println("Unhandled key '"+key+"' released.");
    }
  }
}





class Stickers
{
  float m_thickness;
  float m_side_length;

  int w = color(255,255,255);
  int r = color(255,0,0);
  int g = color(0,255,0);
  int b = color(0,0,255);
  int c = color(0,255,255);
  int m = color(255,0,255);
  int y = color(255,255,0);

  Stickers()
  {
    m_thickness = .08f;
    m_side_length = .9f;
  }

  public void draw( TurnsGraph.Node curTurn)
  {
    int c1 = w;
    int c2 = w;
    int c3 = w;

    switch( curTurn.n)
    {
      case  0: c1 = r; c2 = g; c3 = b; break;
      case  1: c1 = r; c2 = b; c3 = m; break;
      case  2: c1 = y; c2 = g; c3 = r; break;
      case  3: c1 = g; c2 = c; c3 = b; break;
      case  4: c1 = r; c2 = m; c3 = y; break;
      case  5: c1 = g; c2 = b; c3 = r; break;
      case  6: c1 = b; c2 = c; c3 = m; break;
      case  7: c1 = y; c2 = r; c3 = m; break;
      case  8: c1 = c; c2 = g; c3 = y; break;
      case  9: c1 = y; c2 = c; c3 = g; break;
      case 10: c1 = c; c2 = m; c3 = b; break;
      case 11: c1 = r; c2 = y; c3 = g; break;
      case 12: c1 = b; c2 = m; c3 = r; break;
      case 13: c1 = m; c2 = c; c3 = y; break;
      case 14: c1 = g; c2 = r; c3 = y; break;
      case 15: c1 = c; c2 = b; c3 = g; break;
      case 16: c1 = c; c2 = y; c3 = m; break;
      case 17: c1 = m; c2 = y; c3 = r; break;
      case 18: c1 = b; c2 = r; c3 = g; break;
      case 19: c1 = g; c2 = y; c3 = c; break;
      case 20: c1 = m; c2 = b; c3 = c; break;
      case 21: c1 = y; c2 = m; c3 = c; break;
      case 22: c1 = b; c2 = g; c3 = c; break;
      case 23: c1 = m; c2 = r; c3 = b; break;
      default: // Unhandled case.
        println("Unhandled case: curTurn.n = " + curTurn.n);
    }
    
    pushMatrix();
      translate((1+m_thickness/2)/4,0,0);
      fill(c1);
      box((1+m_thickness/2)/2,m_side_length,m_side_length);
    popMatrix();

    pushMatrix();
      translate(0,-(1+m_thickness/2)/4,0);
      fill(c2);
      box(m_side_length,(1+m_thickness/2)/2,m_side_length);
    popMatrix();

    pushMatrix();
      translate(0,0,(1+m_thickness/2)/4);
      fill(c3);
      box(m_side_length,m_side_length,(1+m_thickness/2)/2);
    popMatrix();

    pushMatrix();
      translate(-(1+m_thickness/2)/4,0,0);
      fill(color(255-red(c1),255-green(c1),255-blue(c1)));
      box((1+m_thickness/2)/2,m_side_length,m_side_length);
    popMatrix();

    pushMatrix();
      translate(0, (1+m_thickness/2)/4,0);
      fill(color(255-red(c2),255-green(c2),255-blue(c2)));
      box(m_side_length,(1+m_thickness/2)/2,m_side_length);
    popMatrix();

    pushMatrix();
      translate(0,0,-(1+m_thickness/2)/4);
      fill(color(255-red(c3),255-green(c3),255-blue(c3)));
      box(m_side_length,m_side_length,(1+m_thickness/2)/2);
    popMatrix();
  }
}





class TurnsGraph
{
  class Node
  {
    int n;
    Node x;
    Node y;
    Node z;
    Node( int n0) { n = n0;}
  }

  Node start;

  TurnsGraph()
  {
    start = new Node( 0);
    //  0 rgb (  1,  2,  3)
    start.x = new Node( 1);
    start.y = new Node( 2);
    start.z = new Node( 3);
    //  1 rbm (  4,  5,  6)
    start.x.x = new Node( 4);
    start.x.y = new Node( 5);
    start.x.z = new Node( 6);
    //  2 ygr (  7,  8,  5)
    start.y.x = new Node( 7);
    start.y.y = new Node( 8);
    start.y.z = start.x.y;
    //  3 gcb (  5,  9, 10)
    start.z.x = start.x.y;
    start.z.y = new Node( 9);
    start.z.z = new Node(10);
    //  4 rmy ( 11, 12, 13)
    start.x.x.x = new Node(11);
    start.x.x.y = new Node(12);
    start.x.x.z = new Node(13);
    //  5 gbr ( 14, 15, 12)
    start.x.y.x = new Node(14);
    start.x.y.y = new Node(15);
    start.x.y.z = start.x.x.y;
    //  6 bcm ( 12,  3, 16)
    start.x.z.x = start.x.x.y;
    start.x.z.y =  start.z;
    start.x.z.z = new Node(16);
    //  7 yrm ( 21, 14,  1)
    start.y.x.x = new Node(21);
    start.y.x.y = start.x.y.x;
    start.y.x.z = start.x;
    //  8 cgy ( 16, 22, 14)
    start.y.y.x = start.x.z.z;
    start.y.y.y = new Node(22);
    start.y.y.z = start.x.y.x;
    //  9 ycg (  2, 13, 15)
    start.z.y.x = start.y;
    start.z.y.y = start.x.x.z;
    start.z.y.z = start.x.y.y;
    // 10 cmb ( 15, 21, 23)
    start.z.z.x = start.x.y.y;
    start.z.z.y = start.y.x.x;
    start.z.z.z = new Node(23);
    // 11 ryg (  0, 17,  9)
    start.x.x.x.x = start;
    start.x.x.x.y = new Node(17);
    start.x.x.x.z = start.z.y;
    // 12 bmr ( 18, 10, 17)
    start.x.x.y.x = new Node(18);
    start.x.x.y.y = start.z.z;
    start.x.x.y.z = start.x.x.x.y;
    // 13 mcy ( 17,  6,  8)
    start.x.x.z.x = start.x.x.x.y;
    start.x.x.z.y = start.x.z;
    start.x.x.z.z = start.y.y;
    // 14 gry ( 19, 18,  4)
    start.x.y.x.x = new Node(19);
    start.x.y.x.y = start.x.x.y.x;
    start.x.y.x.z = start.x.x;
    // 15 cbg (  8, 20, 18)
    start.x.y.y.x = start.y.y;
    start.x.y.y.y = new Node(20);
    start.x.y.y.z = start.x.x.y.x;
    // 16 cym ( 10, 19,  7)
    start.x.z.z.x = start.z.z;
    start.x.z.z.y = start.x.y.x.x;
    start.x.z.z.z = start.y.x;
    // 17 myr ( 23, 16,  2)
    start.x.x.x.y.x = start.z.z.z;
    start.x.x.x.y.y = start.x.z.z;
    start.x.x.x.y.z = start.y;
    // 18 brg ( 22, 23, 11)
    start.x.x.y.x.x = start.y.y.y;
    start.x.x.y.x.y = start.z.z.z;
    start.x.x.y.x.z = start.x.x.x;
    // 19 gyc (  3, 11, 21)
    start.x.y.x.x.x = start.z;
    start.x.y.x.x.y = start.x.x.x;
    start.x.y.x.x.z = start.y.x.x;
    // 20 mbc ( 13,  1, 22)
    start.x.y.y.y.x = start.x.x.z;
    start.x.y.y.y.y = start.x;
    start.x.y.y.y.z = start.y.y.y;
    // 21 ymc (  9,  4, 20)
    start.y.x.x.x = start.z.y;
    start.y.x.x.y = start.x.x;
    start.y.x.x.z = start.x.y.y.y;
    // 22 bgc (  6,  0, 19)
    start.y.y.y.x = start.x.z;
    start.y.y.y.y = start;
    start.y.y.y.z = start.x.y.x.x;
    // 23 mrb ( 20,  7,  0)
    start.z.z.z.x = start.x.y.y.y;
    start.z.z.z.y = start.y.x;
    start.z.z.z.z = start;
  }

}

//   +-------+
//  / 2 2 2 /|
// +-------+1|
// | 3 3 3 |1|
// | 3 3 3 |1+
// | 3 3 3 |/ 
// +-------+

//    123
// x  13-
// y  -21
// z  2-3

//  0 rgb
//  1 x rbm
//  4   x rmy
// 11     x ryg
//          x -->  0
// 17       y myr x --> 23 y --> 16 z -->  2
//          z -->  9
// 12     y bmr
// 18       x brg x --> 22 y --> 23 z --> 11
//          y --> 10
//          z --> 17
// 13     z mcy x --> 17 y -->  6 z -->  8
//  5   y gbr
// 14     x gry
// 19       x gyc x -->  3 y --> 11 z --> 21
//          y --> 18
//          z -->  4
// 15     y cbg 
//          x -->  8
// 20       y mbc x --> 13 y -->  1 z --> 22
//          z --> 18
//        z --> 12
//  6   z bcm
//        x --> 12
//        y -->  3
// 16     z cym x --> 10 y --> 19 z -->  7
//  2 y ygr
//  7   x yrm
// 21     x ymc x -->  9 y -->  4 z --> 20
//        y --> 14
//        z -->  1
//  8   y cgy
//        x --> 16
// 22     y bgc x -->  6 y -->  0 z --> 19
//        z --> 14
//      z -->  5
//  3 z gcb
//      x -->  5
//  9   y ycg x -->  2 y --> 13 z --> 15
// 10   z cmb
//        x --> 15
//        y --> 21
// 23     z mrb x --> 20 y -->  7 z -->  0

//  0 rgb (  1,  2,  3)
//  1 rbm (  4,  5,  6)
//  2 ygr (  7,  8,  5)
//  3 gcb (  5,  9, 10)
//  4 rmy ( 11, 12, 13)
//  5 gbr ( 14, 15, 12)
//  6 bcm ( 12,  3, 16)
//  7 yrm ( 21, 14,  1)
//  8 cgy ( 16, 22, 14)
//  9 ycg (  2, 13, 15)
// 10 cmb ( 15, 21, 23)
// 11 ryg (  0, 17,  9)
// 12 bmr ( 18, 10, 17)
// 13 mcy ( 17,  6,  8)
// 14 gry ( 19, 18,  4)
// 15 cbg (  8, 20, 18)
// 16 cym ( 10, 19,  7)
// 17 myr ( 23, 16,  2)
// 18 brg ( 22, 23, 11)
// 19 gyc (  3, 11, 21)
// 20 mbc ( 13,  1, 22)
// 21 ymc (  9,  4, 20)
// 22 bgc (  6,  0, 19)
// 23 mrb ( 20,  7,  0)

//  0 rgb
//  1 x rbm
//  4   x rmy
// 11     x ryg
//          x rgb -->  0
// 17       y myr
//            x mrb --> 23
//            y cym --> 16
//            z ygr -->  2
//          z ycg -->  9
// 12     y bmr
// 18       x brg
//            x bgc --> 22
//            y mrb --> 23
//            z ryg --> 11
//          y cmb --> 10
//          z myr --> 17
// 13     z mcy
//          x myr --> 17
//          y bcm -->  6
//          z cgy -->  8
//  5   y gbr
// 14     x gry
// 19       x gyc
//            x gcb -->  3
//            y ryg --> 11
//            z ymc --> 21
//          y brg --> 18
//          z rmy -->  4
// 15     y cbg 
//          x cgy -->  8
// 20       y mbc
//            x mcy --> 13
//            y rbm -->  1
//            z bgc --> 22
//          z brg --> 18
//        z bmr --> 12
//  6   z bcm
//        x bmr --> 12
//        y gcb -->  3
// 16     z cym
//          x cmb --> 10
//          y gyc --> 19
//          z yrm -->  7
//  2 y ygr
//  7   x yrm
// 21     x ymc
//          x ycg -->  9
//          y rmy -->  4
//          z mbc --> 20
//        y gry --> 14
//        z rbm -->  1
//  8   y cgy
//        x cym --> 16
// 22     y bgc
//          x bcm -->  6
//          y rgb -->  0
//          z gyc --> 19
//        z gry --> 14
//      z gbr -->  5
//  3 z gcb
//      x gbr -->  5
//  9   y ycg
//        x ygr -->  2
//        y mcy --> 13
//        z cbg --> 15
// 10   z cmb
//        x cbg --> 15
//        y ymc --> 21
// 23     z mrb
//          x mbc --> 20
//          y yrm -->  7
//          z rgb -->  0

// switch( orientation_index)
// {
//   case  0: // rgb (  1,  2,  3)
//     break;
//   case  1: // rbm (  4,  5,  6)
//     break;
//   case  2: // ygr (  7,  8,  5)
//     break;
//   case  3: // gcb (  5,  9, 10)
//     break;
//   case  4: // rmy ( 11, 12, 13)
//     break;
//   case  5: // gbr ( 14, 15, 12)
//     break;
//   case  6: // bcm ( 12,  3, 16)
//     break;
//   case  7: // yrm ( 21, 14,  1)
//     break;
//   case  8: // cgy ( 16, 22, 14)
//     break;
//   case  9: // ycg (  2, 13, 15)
//     break;
//   case 10: // cmb ( 15, 21, 23)
//     break;
//   case 11: // ryg (  0, 17,  9)
//     break;
//   case 12: // bmr ( 18, 10, 17)
//     break;
//   case 13: // mcy ( 17,  6,  8)
//     break;
//   case 14: // gry ( 19, 18,  4)
//     break;
//   case 15: // cbg (  8, 20, 18)
//     break;
//   case 16: // cym ( 10, 19,  7)
//     break;
//   case 17: // myr ( 23, 16,  2)
//     break;
//   case 18: // brg ( 22, 23, 11)
//     break;
//   case 19: // gyc (  3, 11, 21)
//     break;
//   case 20: // mbc ( 13,  1, 22)
//     break;
//   case 21: // ymc (  9,  4, 20)
//     break;
//   case 22: // bgc (  6,  0, 19)
//     break;
//   case 23: // mrb ( 20,  7,  0)
//     break;
//   default: // Unhandled case.
// }



  static public void main(String args[]) {     PApplet.main(new String[] { "Rubik" });  }}