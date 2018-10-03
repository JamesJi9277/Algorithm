class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    Set<Integer> set;
    Deque<Integer> body;
    int[][] food;
    int foodIndex;
    int width;
    int height;
    int score;
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        body = new LinkedList<>();
        set = new HashSet<>();
        set.add(0);
        body.offerLast(0);
        score = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (score == -1) {
            return -1;
        }
        int rowHead = body.peek() / width;
        int colHead = body.peek() % width;
        switch (direction) {
            case "U" :
                rowHead--;
                break;
            case "D" :
                rowHead++;
                break;
            case "L" :
                colHead--;
                break;
            case "R" :
                colHead++;
                break;
        }
        int head = rowHead * width + colHead;
        set.remove(body.peekLast());// 如果自己吃到了自己，新的head相当于会fill到原来的尾巴，所以暂时先remove掉尾巴
        //case 1: out of boundary or eating body
        if (rowHead < 0 || rowHead >= height || colHead < 0 || colHead >= width || set.contains(head)) {
            score = -1;
            return score;
        }
        
        // add head for case2 and case3
        set.add(head);
        body.offerFirst(head);
        // case2 : eat food
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            score++;
            set.add(body.peekLast());
            foodIndex++;
            return score;
        }
        // case3 normal move
        body.pollLast();
        return score;
    }
}
class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    Deque<Integer> deque;
    int width;
    int height;
    int head;
    int tail;
    Set<Integer> set;
    int score;
    int[][] food;
    int foodIndex;
    public SnakeGame(int width, int height, int[][] food) {
        deque = new LinkedList<>();
        this.width = width;
        this.height = height;
        head = 0;
        set = new HashSet();
        deque.offer(0);
        set.add(0);
        this.score = 0;
        this.food = food;
        this.foodIndex = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (score == -1) {
            return -1;
        }
        int row = deque.peekFirst() / width;
        int col = deque.peekFirst() % width;
        int head = deque.peek();
        int tail = deque.peekLast();
        if (direction.equals("U")) {
            row--;
        } else if (direction.equals("D")) {
            row++;
        } else if (direction.equals("L")) {
            col--;
        } else {
            col++;
        }
        set.remove(tail);
        int newHead = row * width + col;
        if (row < 0 || row >= height || col < 0 || col >= width || set.contains(newHead)) {
            score = -1;
            return -1;
        }
        deque.offerFirst(newHead);
        set.add(newHead);
        if (foodIndex < food.length && food[foodIndex][0] == row && food[foodIndex][1] == col) {
            score++;
            set.add(tail);
            foodIndex++;
            return score;
        }
        deque.pollLast();
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
