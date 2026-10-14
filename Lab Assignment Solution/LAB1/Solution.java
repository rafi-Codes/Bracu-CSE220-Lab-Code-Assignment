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
