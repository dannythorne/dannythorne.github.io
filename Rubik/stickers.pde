
class Stickers
{
  float m_thickness;
  float m_side_length;

  color w = color(255,255,255);
  color r = color(255,0,0);
  color g = color(0,255,0);
  color b = color(0,0,255);
  color c = color(0,255,255);
  color m = color(255,0,255);
  color y = color(255,255,0);

  Stickers()
  {
    m_thickness = .08;
    m_side_length = .9;
  }

  void draw( TurnsGraph.Node curTurn)
  {
    color c1 = w;
    color c2 = w;
    color c3 = w;

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



