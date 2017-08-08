package me.ienze.twoDimMap;

public class Vec {

    public int x;
    public int y;

    public Vec(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec(Vec vec2i) {
        this.x = vec2i.x;
        this.y = vec2i.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vec other = (Vec) obj;
        if (x != other.x)
            return false;
        return y == other.y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
