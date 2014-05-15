


class Axes
{
  float m_width, m_length;
  int m_alpha;
  Axes()
  {
    m_width=.1;
    m_length=20;
    m_alpha = 255;
  }
  Axes( float init_width, float init_length, int init_alpha)
  {
    m_width=init_width;
    m_length=init_length;
    m_alpha=init_alpha;
  }
  void draw()
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



