//import processing.opengl.*;

float s; // scale factor
float px, py; // perspective
boolean shift_is_on;
boolean middle;
boolean Middle;

//Cubie cube;
Cube cube;
Axes axes = new Axes(.05,200,255);

History history;

PFont font;

void setup()
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

void draw()
{
  background(#ddddcc);

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

void keyPressed()
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
        switch(int(random(0,23)))
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
      case ' ': if( shift_is_on) { s/=1.1;} else { s*=1.1;} break;
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

void keyReleased()
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



