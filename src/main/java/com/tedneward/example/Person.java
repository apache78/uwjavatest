package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person>{
 // private final int a;
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private static int totalCount=0;


  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    this.name = n;
    this.age = a;
    this.salary = s;
    this.ssn = null;
    this.totalCount++;
  }

  public int getAge() {
    return age;
  }
  public void setAge(int a) throws IllegalArgumentException{
    if(a<0){
      throw new IllegalArgumentException("Age must be value greater than 0.");
    }
    this.age = a;
  }
  public String getName() {
    return name;
  }

  public void setName(String s) throws IllegalArgumentException{
    if(s==null){
      throw new IllegalArgumentException("Name must be a non null value.");
    }
    this.name = s;
  }
  public void setSalary(double d){
    this.salary = d;
  }
  public double getSalary() {
    return salary;
  }

  public int count(){
    return totalCount;
  }

  public String getSSN() {
    return ssn;
  }
  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  public boolean equals(Person p) {
    return (this.name.equals(p.name) && this.age == p.age);
  }

  public int compareTo(Person other){
    return -1* Double.compare(this.getSalary(), other.getSalary());
  }

  public static ArrayList<Person> getNewardFamily(){
    ArrayList<Person> family;
    family = new ArrayList<>();
    Person p = new Person("Ted", 41, 250000.0);
    family.add(p);
    p = new Person("Charlotte", 43, 150000.0);
    family.add(p);
    p = new Person("Michael", 22, 10000.0);
    family.add(p);
    p = new Person("Matthew", 15, 0.0);
    family.add(p);

    return family;
  }

  public String tostring() {
    return "{{FIXME}}";
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }


  class AgeComparator implements Comparator<Person>{
    public int compare(Person p1, Person p2){
      return p2.getAge() - p1.getAge();
    }
  }
}
