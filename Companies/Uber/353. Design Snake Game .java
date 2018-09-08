class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    int[][] food;
    int foodIndex;
    Set<Integer> set;
    Deque<Integer> body;
    int width;
    int height;
    int score;
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.width = width;
        this.height = height;
        body = new LinkedList();
        set = new HashSet<>();
        set.add(0);
        body.offerFirst(0);
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
            case "D":
                rowHead++;
                break;
            case "L":
                colHead--;
                break;
            case "R" :
                colHead++;
                break;
        }
        int head = rowHead * width + colHead;
        set.remove(body.peekLast());
        if (rowHead < 0 || rowHead >= height || colHead < 0 || colHead >= width || set.contains(head)) {
            score = -1;
            return score;
        }
        
        set.add(head);
        body.offerFirst(head);
        
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            score++;
            foodIndex++;
            set.add(body.peekLast());
            return score;
        }
        
        body.pollLast();
        return score;
        
    }
}