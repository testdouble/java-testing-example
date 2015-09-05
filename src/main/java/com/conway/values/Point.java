package com.conway.values;

public class Point {
  
  public Contents contents;
  public Coordinates coordinates;
  
  public Point(Contents contents, Coordinates coordinates) {
    this.contents = contents;
    this.coordinates = coordinates;
  }
  
  public String toString() {
    return contents.getClass().getName() + " at ( "+coordinates.x+", "+coordinates.y+")";
  }

//  @Override
//  public int hashCode() {
//    final int prime = 31;
//    int result = 1;
//    result = prime * result + ((contents == null) ? 0 : contents.hashCode());
//    result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
//    return result;
//  }
//
//  @Override
//  public boolean equals(Object obj) {
//    if (this == obj)
//      return true;
//    if (obj == null)
//      return false;
//    if (!(obj instanceof Point))
//      return false;
//    Point other = (Point) obj;
//    if (contents == null) {
//      if (other.contents != null)
//        return false;
//    } else if (!contents.equals(other.contents))
//      return false;
//    if (coordinates == null) {
//      if (other.coordinates != null)
//        return false;
//    } else if (!coordinates.equals(other.coordinates))
//      return false;
//    return true;
//  }

}
