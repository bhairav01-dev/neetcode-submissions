class Solution {
    private boolean isBoxValid(char[][] board, int i, int j){
        Set<Character> st = new HashSet<>();
        for(int p=i; p<i+3; p++){
            for(int q=j; q<j+3; q++){
                if(board[p][q] == '.') continue;
                if(st.contains(board[p][q])){
                    return false;
                }
                st.add(board[p][q]);
            }
        }
        return true;
    }

    private boolean isAxisValid(char[][] board, int j, boolean isRow){
        Set<Character> st = new HashSet<>();
        for(int p=0; p<9; p++){
            if(isRow){
                if(board[j][p] == '.') continue;
                if(st.contains(board[j][p])){
                    return false;
                }
                st.add(board[j][p]);
            }
            else{
                if(board[p][j]== '.') continue;
                if(st.contains(board[p][j])){
                    return false;
                }
                st.add(board[p][j]);
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            if(!isAxisValid(board,i, true) 
            || !isAxisValid(board,i,false)){
                return false;
            }
        }
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                if(!isBoxValid(board,i,j)){
                    return false;
                }
            }
        }
        return true;
    }
}
