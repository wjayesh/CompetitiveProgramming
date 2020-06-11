class BrowserHistory {
    Stack<String> s1 = new Stack<String>();
    Stack<String> s2 = new Stack<String>();
    
    public BrowserHistory(String homepage) {
        s1.push(homepage);
        s2 = new Stack<String>();
    }
    
    public void visit(String url) {
        s1.push(url);
        s2 = new Stack<String>();
    }
    
    public String back(int steps) {
        if(s1.size() == 1)
            return s1.peek();
        
        if(steps >= s1.size())
            steps= s1.size()-1;
        
        while(steps-- > 0)
            s2.push(s1.pop());
        
        return s1.peek();
    }
    
    public String forward(int steps) {
        if(s2.size() == 0)
            return s1.peek();
        
        if(steps > s2.size())
            steps= s2.size();
        
        while(steps-- > 0)
            s1.push(s2.pop());
        
        return s1.peek();
    }
}
