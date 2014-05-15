
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

  void draw()
  {
    ru.draw(); rd.draw(); lu.draw(); ld.draw();
    uf.draw(); df.draw(); ub.draw(); db.draw();
    rf.draw(); rb.draw(); lf.draw(); lb.draw();
    
    ruf.draw(); rub.draw(); rdf.draw(); rdb.draw();
    luf.draw(); lub.draw(); ldf.draw(); ldb.draw();

    r.draw(); l.draw(); u.draw(); d.draw(); f.draw(); b.draw();
  }

  void xTurn()
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
  void yTurn()
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
  void zTurn()
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
  void xTurnBack()
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
  void yTurnBack()
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
  void zTurnBack()
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

  void rTurn()
  { ru.xTurn(); rd.xTurn(); rf.xTurn(); rb.xTurn(); ruf.xTurn(); rub.xTurn(); rdf.xTurn(); rdb.xTurn(); r.xTurn();
    Cubie temp = ru;   ru = rf;   rf = rd;   rd = rb;   rb = temp;
          temp = ruf; ruf = rdf; rdf = rdb; rdb = rub; rub = temp; }
  void rTurnBack()
  { ru.xTurnBack(); rd.xTurnBack(); rf.xTurnBack(); rb.xTurnBack(); ruf.xTurnBack(); rub.xTurnBack(); rdf.xTurnBack(); rdb.xTurnBack(); r.xTurnBack();
    Cubie temp = ru;   ru = rb;   rb = rd;   rd = rf;   rf = temp;
          temp = ruf; ruf = rub; rub = rdb; rdb = rdf; rdf = temp; }
  void mrTurn()
  { uf.xTurn(); df.xTurn(); ub.xTurn(); db.xTurn(); u.xTurn(); d.xTurn(); f.xTurn(); b.xTurn();
    Cubie temp = uf; uf = df; df = db; db = ub; ub = temp;
          temp = f;   f = d;   d = b;   b = u;   u = temp; }

  void lTurn()
  { lu.xTurnBack(); ld.xTurnBack(); lf.xTurnBack(); lb.xTurnBack(); luf.xTurnBack(); lub.xTurnBack(); ldf.xTurnBack(); ldb.xTurnBack(); l.xTurnBack();
    Cubie temp = lu;   lu = lb;   lb = ld;   ld = lf;   lf = temp;
          temp = luf; luf = lub; lub = ldb; ldb = ldf; ldf = temp; }
  void lTurnBack()
  { lu.xTurn(); ld.xTurn(); lf.xTurn(); lb.xTurn(); luf.xTurn(); lub.xTurn(); ldf.xTurn(); ldb.xTurn(); l.xTurn();
    Cubie temp = lu;   lu = lf;   lf = ld;   ld = lb;   lb = temp;
          temp = luf; luf = ldf; ldf = ldb; ldb = lub; lub = temp; }
  void mlTurn()
  { uf.xTurnBack(); df.xTurnBack(); ub.xTurnBack(); db.xTurnBack(); u.xTurnBack(); d.xTurnBack(); f.xTurnBack(); b.xTurnBack();
    Cubie temp = uf; uf = ub; ub = db; db = df; df = temp;
          temp = f;   f = u;   u = b;   b = d;   d = temp; }

  void uTurn()
  { ru.yTurn(); lu.yTurn(); uf.yTurn(); ub.yTurn(); ruf.yTurn(); rub.yTurn(); luf.yTurn(); lub.yTurn(); u.yTurn();
    Cubie temp = ru;   ru = ub;   ub = lu;   lu = uf;   uf = temp;
          temp = ruf; ruf = rub; rub = lub; lub = luf; luf = temp; }
  void uTurnBack()
  { ru.yTurnBack(); lu.yTurnBack(); uf.yTurnBack(); ub.yTurnBack(); ruf.yTurnBack(); rub.yTurnBack(); luf.yTurnBack(); lub.yTurnBack(); u.yTurnBack();
    Cubie temp = ru;   ru = uf;   uf = lu;   lu = ub;   ub = temp;
          temp = ruf; ruf = luf; luf = lub; lub = rub; rub = temp; }
  void muTurn()
  { rf.yTurn(); rb.yTurn(); lf.yTurn(); lb.yTurn(); r.yTurn(); l.yTurn(); f.yTurn(); b.yTurn();
    Cubie temp = rf; rf = rb; rb = lb; lb = lf; lf = temp;
          temp = r;   r = b;   b = l;   l = f;   f = temp; }

  void dTurn()
  { rd.yTurnBack(); ld.yTurnBack(); df.yTurnBack(); db.yTurnBack(); rdf.yTurnBack(); rdb.yTurnBack(); ldf.yTurnBack(); ldb.yTurnBack(); d.yTurnBack();
    Cubie temp = rd;   rd = df;   df = ld;   ld = db;   db = temp;
          temp = rdf; rdf = ldf; ldf = ldb; ldb = rdb; rdb = temp; }
  void dTurnBack()
  { rd.yTurn(); ld.yTurn(); df.yTurn(); db.yTurn(); rdf.yTurn(); rdb.yTurn(); ldf.yTurn(); ldb.yTurn(); d.yTurn();
    Cubie temp = rd;   rd = db;   db = ld;   ld = df;   df = temp;
          temp = rdf; rdf = rdb; rdb = ldb; ldb = ldf; ldf = temp; }
  void mdTurn()
  { rf.yTurnBack(); rb.yTurnBack(); lf.yTurnBack(); lb.yTurnBack(); r.yTurnBack(); l.yTurnBack(); f.yTurnBack(); b.yTurnBack();
    Cubie temp = rf; rf = lf; lf = lb; lb = rb; rb = temp;
          temp = r;   r = f;   f = l;   l = b;   b = temp; }

  void fTurn()
  { uf.zTurn(); df.zTurn(); rf.zTurn(); lf.zTurn(); ruf.zTurn(); rdf.zTurn(); luf.zTurn(); ldf.zTurn(); f.zTurn();
    Cubie temp = uf;   uf = lf;   lf = df;   df = rf;   rf = temp;
          temp = ruf; ruf = luf; luf = ldf; ldf = rdf; rdf = temp; }
  void fTurnBack()
  { uf.zTurnBack(); df.zTurnBack(); rf.zTurnBack(); lf.zTurnBack(); ruf.zTurnBack(); rdf.zTurnBack(); luf.zTurnBack(); ldf.zTurnBack(); f.zTurnBack();
    Cubie temp = uf;   uf = rf;   rf = df;   df = lf;   lf = temp;
          temp = ruf; ruf = rdf; rdf = ldf; ldf = luf; luf = temp; }
  void mfTurn()
  { ru.zTurn(); rd.zTurn(); lu.zTurn(); ld.zTurn(); r.zTurn(); l.zTurn(); u.zTurn(); d.zTurn();
    Cubie temp = ru; ru = lu; lu = ld; ld = rd; rd = temp;
          temp = r;   r = u;   u = l;   l = d;   d = temp; }

  void bTurn()
  { ub.zTurnBack(); db.zTurnBack(); rb.zTurnBack(); lb.zTurnBack(); rub.zTurnBack(); rdb.zTurnBack(); lub.zTurnBack(); ldb.zTurnBack(); b.zTurnBack();
    Cubie temp = ub;   ub = rb;   rb = db;   db = lb;   lb = temp;
          temp = rub; rub = rdb; rdb = ldb; ldb = lub; lub = temp; }
  void bTurnBack()
  { ub.zTurn(); db.zTurn(); rb.zTurn(); lb.zTurn(); rub.zTurn(); rdb.zTurn(); lub.zTurn(); ldb.zTurn(); b.zTurn();
    Cubie temp = ub;   ub = lb;   lb = db;   db = rb;   rb = temp;
          temp = rub; rub = lub; lub = ldb; ldb = rdb; rdb = temp; }
  void mbTurn()
  { ru.zTurnBack(); rd.zTurnBack(); lu.zTurnBack(); ld.zTurnBack(); r.zTurnBack(); l.zTurnBack(); u.zTurnBack(); d.zTurnBack();
    Cubie temp = ru; ru = rd; rd = ld; ld = lu; lu = temp;
          temp = r;   r = d;   d = l;   l = u;   u = temp; }


}





