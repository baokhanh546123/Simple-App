package LTGD;

import java.util.*;

public class Sort {

    public int[] insertion(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int current_value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current_value) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current_value;
        }
        return arr;
    }

    public int[] selection(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_value = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_value]) {
                    min_value = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_value];
            arr[min_value] = temp;
        }
        return arr;
    }
    
    public Student[] insertion(Student[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Student current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getMssv().compareTo(current.getMssv()) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        return arr;
    }

    public Student[] selection(Student[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].getMssv().compareTo(arr[minIndex].getMssv()) < 0) {
                    minIndex = j;
                }
            }
            Student temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] original = {5, 2, 8, 3, 1};
        Sort sorter = new Sort();

        int[] arr1 = Arrays.copyOf(original, original.length);
        int[] arr2 = Arrays.copyOf(original, original.length);

        System.out.println("Original: " + Arrays.toString(original));

        sorter.insertion(arr1);
        System.out.println("Insertion Sort: " + Arrays.toString(arr1));

        sorter.selection(arr2);
        System.out.println("Selection Sort: " + Arrays.toString(arr2));
        
        Student[] students = new Student[]{
                new Student("SV003", "Nguyen", "Anh", new Date(99, 3, 5)),
                new Student("SV002", "Tran", "Bich", new Date(99, 3, 6)),
                new Student("SV001", "Le", "Cao", new Date(99, 3, 2))
            };

          
            System.out.println("Original Students:");
            for (Student s : students) {
                System.out.println(s);
            }

          
            sorter.insertion(students);
            System.out.println("\nSorted Students by MSSV (Insertion Sort):");
            for (Student s : students) {
                System.out.println(s);
            }

            sorter.selection(students);
            System.out.println("\nSorted Students by MSSV (Selection Sort):");
            for (Student s : students) {
                System.out.println(s);
            }
        }

    }

