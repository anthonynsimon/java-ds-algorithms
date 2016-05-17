package anthonynsimon.datastructures.util;

public class HashTableNode<K, V> {
  
  private K key;
  private V value;
  private HashTableNode<K, V> next;
  
  public HashTableNode(K key, V value) {
    this.key = key;
    this.value = value;
    this.next = null;
  }
  
  public K getKey() {
    return this.key;
  }
  
  public V getValue() {
    return this.value;
  }

  public HashTableNode getNext() {
    return this.next;
  }
  
  public void setKey(K key) {
    this.key = key;
  }
  
  public void setValue(V value) {
    this.value = value;
  }

  public void setNext(HashTableNode node) {
    this.next = node;
  }
}