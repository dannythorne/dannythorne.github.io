
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

  void push( int n)
  {
    if( tail.next == null)
    {
      tail.next = new Node(n);
      tail.next.prev = tail;
    }
    tail = tail.next;
    tail.n = n;
  }

  boolean push()
  {
    if( tail.next != null) { tail = tail.next; return true;}
    return false;
  }

  void pop()
  {
    if( tail != head)
    {
      tail = tail.prev;
    }
  }

  int top() { return tail.n;}

  void draw()
  {
    stroke(255);
    fill(255);
    //textAlign(CENTER);
    textAlign(LEFT);
    int x;
    int dx = 18;

    Node cur = tail;
    if( cur==head) { cur=cur.next; fill(192);} else { fill(0);}
    x = round((.67)*width);
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
        case 19: text("m",x,24); x+=.9*dx; textFont(font,18); text("r",x,24+8); /* x+=1.67*dx;*/ break;
        case 20: text("m",x,24); x+=.9*dx; textFont(font,18); text("l",x,24+8); /* x+=1.67*dx;*/ break;
        case 21: text("m",x,24); x+=.9*dx; textFont(font,18); text("u",x,24+8); /* x+=1.67*dx;*/ break;
        case 22: text("m",x,24); x+=.9*dx; textFont(font,18); text("d",x,24+8); /* x+=2*dx;   */ break;
        case 23: text("m",x,24); x+=.9*dx; textFont(font,18); text("f",x,24+8); /* x+=1.67*dx;*/ break;
        case 24: text("m",x,24); x+=.9*dx; textFont(font,18); text("b",x,24+8); /* x+=1.67*dx;*/ break;
        default: println("Unhandled case: cur.n = " + cur.n); exit();
      }
      cur = cur.next;
      x += dx;
      fill(192);
    }

    cur = tail.prev;
    x = round((.67)*width) - dx;
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
        case 19: x-=.9*dx; text("m",x,24); x+=.9*dx; textFont(font,18); text("r",x,24+8); x-=.9*dx; /* x+=1.67*dx;*/ break;
        case 20: x-=.9*dx; text("m",x,24); x+=.9*dx; textFont(font,18); text("l",x,24+8); x-=.9*dx; /* x+=1.67*dx;*/ break;
        case 21: x-=.9*dx; text("m",x,24); x+=.9*dx; textFont(font,18); text("u",x,24+8); x-=.9*dx; /* x+=1.67*dx;*/ break;
        case 22: x-=.9*dx; text("m",x,24); x+=.9*dx; textFont(font,18); text("d",x,24+8); x-=.9*dx; /* x+=2*dx;   */ break;
        case 23: x-=.9*dx; text("m",x,24); x+=.9*dx; textFont(font,18); text("f",x,24+8); x-=.9*dx; /* x+=1.67*dx;*/ break;
        case 24: x-=.9*dx; text("m",x,24); x+=.9*dx; textFont(font,18); text("b",x,24+8); x-=.9*dx; /* x+=1.67*dx;*/ break;
        default: println("Unhandled case: cur.n = " + cur.n); exit();
      }
      cur = cur.prev;
      x -= dx;
    }
  }

} // class History



