Union & Intersection of 2 array

  public static void main(String[] args) {
        int arr1[] = {7, 3, 9, 6};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> set = new HashSet<>();

        //union 
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("Union= "+set.size()+ set);

        //Inersection
        set.clear();
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        int count = 0;
        for(int i=0; i<arr2.length; i++) {
            if(set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
                System.out.println(arr2[i]);
            }
        }
        System.out.println("Intersection= "+count); 
    }

output is: 
  Union= 6
  Intersection= 3
