package tankegame_;

import java.util.Vector;

/**
 * @author Asahi
 * 防止坦克碰撞
 */
@SuppressWarnings({"all"})
public class anti_ {
   public static boolean ai(tank_ t1, Vector<tankai_> tankai_s){
       switch (t1.getDir()) {
           case 0: //上
               //让当前敌人坦克和其它所有的敌人坦克比较
               for (int i = 0; i < tankai_s.size(); i++) {
                   //从vector 中取出一个敌人坦克
                   tankai_ tankai_ = tankai_s.get(i);
                   //不和自己比较
                   if (tankai_ != t1) {
                       //如果敌人坦克是上/下
                       if (tankai_.getDir() == 0 || tankai_.getDir() == 1) {
                           if (t1.getX() >= tankai_.getX()
                                   && t1.getX() <= tankai_.getX() + 40
                                   && t1.getY() >= tankai_.getY()
                                   && t1.getY() <= tankai_.getY() + 60) {
                               return true;
                           }
                           if (t1.getX() + 40 >= tankai_.getX()
                                   && t1.getX() + 40 <= tankai_.getX() + 40
                                   && t1.getY() >= tankai_.getY()
                                   && t1.getY() <= tankai_.getY() + 60) {
                               return true;
                           }
                       }
                       //如果敌人坦克是 右/左
                       if (tankai_.getDir() == 2 || tankai_.getDir() == 3) {
                           if (t1.getX() >= tankai_.getX()
                                   && t1.getX() <= tankai_.getX() + 60
                                   && t1.getY() >= tankai_.getY()
                                   && t1.getY() <= tankai_.getY() + 40) {
                               return true;
                           }
                           if (t1.getX() + 40 >= tankai_.getX()
                                   && t1.getX() + 40 <= tankai_.getX() + 60
                                   && t1.getY() >= tankai_.getY()
                                   && t1.getY() <= tankai_.getY() + 40) {
                               return true;
                           }
                       }
                   }

               }
               break;
           case 1: //下
               //让当前敌人坦克和其它所有的敌人坦克比较
               for (int i = 0; i < tankai_s.size(); i++) {
                   //从vector 中取出一个敌人坦克
                   tankai_ tankai_ = tankai_s.get(i);
                   //不和自己比较
                   if (tankai_ != t1) {
                       //如果敌人坦克是上/下
                       if (tankai_.getDir() == 0 || tankai_.getDir() == 1) {
                           if (t1.getX() >= tankai_.getX()
                                   && t1.getX() <= tankai_.getX() + 40
                                   && t1.getY() + 60 >= tankai_.getY()
                                   && t1.getY() + 60 <= tankai_.getY() + 60) {
                               return true;
                           }
                           if (t1.getX() + 40 >= tankai_.getX()
                                   && t1.getX() + 40 <= tankai_.getX() + 40
                                   && t1.getY() + 60 >= tankai_.getY()
                                   && t1.getY() + 60 <= tankai_.getY() + 60) {
                               return true;
                           }
                       }
                       //如果敌人坦克是 右/左
                       if (tankai_.getDir() == 2 || tankai_.getDir() == 3) {
                           if (t1.getX() >= tankai_.getX()
                                   && t1.getX() <= tankai_.getX() + 60
                                   && t1.getY() + 60 >= tankai_.getY()
                                   && t1.getY() + 60 <= tankai_.getY() + 40) {
                               return true;
                           }
                           if (t1.getX() + 40 >= tankai_.getX()
                                   && t1.getX() + 40 <= tankai_.getX() + 60
                                   && t1.getY() + 60 >= tankai_.getY()
                                   && t1.getY() + 60 <= tankai_.getY() + 40) {
                               return true;
                           }
                       }
                   }
               }
               break;
           case 2: //左
               //让当前敌人坦克和其它所有的敌人坦克比较
               for (int i = 0; i < tankai_s.size(); i++) {
                   //从vector 中取出一个敌人坦克
                   tankai_ tankai_ = tankai_s.get(i);
                   //不和自己比较
                   if (tankai_ != t1) {
                       //如果敌人坦克是上/下
                       if (tankai_.getDir() == 0 || tankai_.getDir() == 1) {
                           if (t1.getX() >= tankai_.getX()
                                   && t1.getX() <= tankai_.getX() + 40
                                   && t1.getY() >= tankai_.getY()
                                   && t1.getY() <= tankai_.getY() + 60) {
                               return true;
                           }
                           if (t1.getX() >= tankai_.getX()
                                   && t1.getX() <= tankai_.getX() + 40
                                   && t1.getY() + 40 >= tankai_.getY()
                                   && t1.getY() + 40 <= tankai_.getY() + 60) {
                               return true;
                           }
                       }
                       //如果敌人坦克是 右/左
                       if (tankai_.getDir() == 2 || tankai_.getDir() == 3) {
                           if (t1.getX() >= tankai_.getX()
                                   && t1.getX() <= tankai_.getX() + 60
                                   && t1.getY() >= tankai_.getY()
                                   && t1.getY() <= tankai_.getY() + 40) {
                               return true;
                           }
                           if (t1.getX() >= tankai_.getX()
                                   && t1.getX() <= tankai_.getX() + 60
                                   && t1.getY() + 40 >= tankai_.getY()
                                   && t1.getY() + 40 <= tankai_.getY() + 40) {
                               return true;
                           }
                       }
                   }
               }
               break;
           case 3: //右
               //让当前敌人坦克和其它所有的敌人坦克比较
               for (int i = 0; i < tankai_s.size(); i++) {
                   //从vector 中取出一个敌人坦克
                   tankai_ tankai_ = tankai_s.get(i);
                   //不和自己比较
                   if (tankai_ != t1) {
                       //如果敌人坦克是上/下

                       if (tankai_.getDir() == 0 || tankai_.getDir() == 1) {
                           if (t1.getX() + 60 >= tankai_.getX()
                                   && t1.getX() + 60 <= tankai_.getX() + 40
                                   && t1.getY() >= tankai_.getY()
                                   && t1.getY() <= tankai_.getY() + 60) {
                               return true;
                           }
                           if (t1.getX() + 60 >= tankai_.getX()
                                   && t1.getX() + 60 <= tankai_.getX() + 40
                                   && t1.getY() + 40 >= tankai_.getY()
                                   && t1.getY() + 40 <= tankai_.getY() + 60) {
                               return true;
                           }
                       }
                       //如果敌人坦克是 右/左
                       if (tankai_.getDir() == 2 || tankai_.getDir() == 3) {
                           if (t1.getX() + 60 >= tankai_.getX()
                                   && t1.getX() + 60 <= tankai_.getX() + 60
                                   && t1.getY() >= tankai_.getY()
                                   && t1.getY() <= tankai_.getY() + 40) {
                               return true;
                           }
                           if (t1.getX() + 60 >= tankai_.getX()
                                   && t1.getX() + 60 <= tankai_.getX() + 60
                                   && t1.getY() + 40 >= tankai_.getY()
                                   && t1.getY() + 40 <= tankai_.getY() + 40) {
                               return true;
                           }
                       }
                   }
               }
               break;
       }
       return false;
   }
}
