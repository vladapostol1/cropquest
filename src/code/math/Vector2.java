package code.math;

public class Vector2 {
    public int x;
    public int y;

    public Vector2() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void Add(Vector2 src){
        this.x += src.x;
        this.y += src.y;
    }

    public void Sub(Vector2 src){
        this.x -= src.x;
        this.y -= src.y;
    }

    public void Mul(Vector2 src){
        this.x *= src.x;
        this.y *= src.y;
    }

    public void Div(Vector2 src){
        if(src.x != 0 &&  src.y != 0)
        {
            this.x += src.x;
            this.y += src.y;
        }
    }

}
