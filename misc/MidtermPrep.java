public class MidtermPrep {
    public static void main(String[] args){
        int[] arr1 = {11, 10, 9, 8, 7, 5, 4, 3, 2, 1};
        int[] arr2 = new int[11]; 
        
        arr2 = updateTopTen(arr1, 6);

        System.out.println(arr1);
        System.out.println(arr2);


        return; 
    }

    public static int[] updateTopTen(int[] topTen, int score){
        //assuming the list topTen is sorted. 
        int[] newTopTen = new int[topTen.length];
        int position = -1; 
        
        //find the position of the score in the topTen list
        for(int i = 0; i < topTen.length; i++){
            if(score > topTen[i]){
                position = i; 
                break; 
            }
        }

        //if the score is not in the top ten, return the original list
        if(position == -1){
            return topTen; 
        }

        //if the score is in the top ten, update the list
        for(int i = 0; i < position; i++){
            newTopTen[i] = topTen[i];
        }
        newTopTen[position] = score;
        for(int i = position + 1; i < newTopTen.length; i++){
            newTopTen[i] = topTen[i - 1];
        }


        return newTopTen;
    
    }
}
