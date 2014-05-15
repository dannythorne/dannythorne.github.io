
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


