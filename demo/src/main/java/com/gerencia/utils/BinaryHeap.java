package com.gerencia.utils;

import java.util.ArrayList;

public class BinaryHeap<T extends Comparable<T>> {

    public ArrayList<T> heap = new ArrayList<T>(); 

    public T left_node(Integer index){
        Integer left_index = 2 * index + 1;
        if(left_index > heap.size()-1){
            return null;
        }
        return heap.get(left_index);
    }

    public T right_node(Integer index){
        Integer right_index = 2 * index + 2;
        if(right_index > heap.size()-1){
            return null;
        }
        return heap.get(right_index);
    }

    public T parent_node(Integer index){
        Integer parent_index = (index - 1)/2;
        return heap.get(parent_index);
    }

    public void insert_node(T nodeT){
        heap.add(nodeT);
        int last_index = heap.size()-1;
        
        
        while (last_index > 0 ) {
            int parent_index =(last_index - 1)/2;
            T parent = parent_node(last_index);

            if( nodeT.compareTo(parent) >= 0  ){
            break;
            }

            heap.set(last_index, parent);
            heap.set(parent_index, nodeT);
            last_index = parent_index;

        }
    }

    public T pop(){
        T root = null;
        if(heap.isEmpty()){
            System.out.println("Nao existe mais objetos no array!");
            return root;
        }
        if(heap.size() > 1){
            T new_root = heap.get(heap.size()-1);
            root = heap.set(0, new_root);
            heap.remove(heap.size()-1);
            this.fix_tree(0);
            return root;
        }
        if(heap.size() == 1){
            root = heap.get(0);
            heap.remove(0);
            return root;
        }
        
        return root;
    }

    private void fix_tree(int index){
        
        T root = heap.get(index);
        T left = left_node(index);
        T right = right_node(index);
        int last_index = index;
        index = compare_right_left(root, left, right, index);
        if(index != last_index){
            T temp = heap.get(index);
            heap.set(index ,heap.get(last_index) );
            heap.set(last_index,temp );
            fix_tree(index);
        }
    
    }

    private int compare_right_left(T root, T left, T right, int index){
        if((left != null)&&(right != null)){
            if(left.compareTo(right)== 0){
            
                if(root.compareTo(left) > 0 ){
                    return heap.indexOf(left);
                }
            }
        }

        if(left != null){
            if(root.compareTo(left)> 0){
                return heap.indexOf(left);    
            }  
        }
        if(right != null){
            if(root.compareTo(right) > 0 ){
                return  heap.indexOf(right);       
            }
        }
        
        return index;
    }

    public boolean isEmpty(){
        if(heap.isEmpty()){
            return true;
        }
        return false;
    }
    public boolean contains(T objeto){
        return heap.contains(objeto);
    }
}
