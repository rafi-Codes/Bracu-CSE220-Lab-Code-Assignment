// Task 01
public static Integer rowRotation( Integer examWeek, String[][] matrix ){

        int row = matrix.length;

        int pass = (examWeek - 1) % row;
        if (pass < 0) {
            pass += row;
        }

        for (int i = 0; i < pass; i++) {
            String[] bottomRow = matrix[row - 1];
            for (int j = row - 1; j > 0; j--) {
                matrix[j] = matrix[j - 1];
            }
            matrix[0] = bottomRow;
        }

        Arr.print2D(matrix);
        int ans = (row - 1 + pass) % row;
        
        return ans + 1;
}

// Task 02
public static Integer[][] compressMatrix( Integer[][] matrix ){
       Integer[][] comp = new Integer[matrix.length/2][matrix[0].length/2];
       int row = 0;
       for (int i = 0; i < matrix.length-1; i+=2){
        int col = 0;
        for(int j = 0; j < matrix[0].length-1; j+= 2){
            comp[row][col++] = matrix[i][j] + matrix[i+1][j] + matrix[i][j+1] + matrix[i+1][j+1];
        }
        row++;
       }
       return comp;
}

// Task 03
public static void playGame( Integer[][] arena ){

        int Points = 0;
        for(int i = 0; i < arena.length; i++){
            for (int j = 0; j < arena[0].length; j++){
                if (arena[i][j] % 50 == 0 && arena[i][j] > 0){
                    if(i + 1 < arena.length && arena[i+1][j] == 2){
                        Points++;
                    } 
                    if (i - 1 >= 0 && arena[i-1][j] == 2){
                        Points++;
                    }
                    if(j + 1 < arena[0].length && arena[i][j+1] == 2){
                        Points++;
                    } 
                    if (j - 1 >= 0 && arena[i][j-1] == 2){
                        Points++;
                    }
                }
            }
        }

        Points *=2;
        System.out.print("Points Gained: " + Points +". "); 
        if (Points < 10){
            System.out.println("Your team is out.");
        } else {
            System.out.println("Your team has survived the game.");
        }
}
