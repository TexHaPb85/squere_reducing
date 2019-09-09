public class Quadrate {
    public Quadrate leftUp;
    public Quadrate rightUp;
    public Quadrate leftDown;
    public Quadrate rightDown;

    public Quadrate() {
    }

    public Quadrate(Quadrate leftUp, Quadrate rightUp, Quadrate leftDown, Quadrate rightDown) {
        this.leftUp = leftUp;
        this.rightUp = rightUp;
        this.leftDown = leftDown;
        this.rightDown = rightDown;
    }

    public Quadrate merge(Quadrate otherQuadrate) {
        System.out.println("this=" + this);
        System.out.println("other=" + otherQuadrate);
        /**
         * если хотя бы 1 из квадратов белый то результат тоже будет белый
         */
        if (this.equals(Q.white) || otherQuadrate.equals(Q.white)) {
            System.out.println(this + "\n+\n" + otherQuadrate + "\n=\n" + Q.white);
            return Q.white;
        }
        /**
         * на этом условии подразумевается, что this - черный квадрат без детей,
         * а это означает, что при слиянии с любым другим квадратом, независимо от того есть у него дети или нет,
         * вернется квадрат идентичный другому(тому, что принимается)
         * else if (!this.hasChildren()) {
         */
        else if (this.equals(Q.black)) {
            System.out.println(this + "\n+\n" + otherQuadrate + "\n=\n" + otherQuadrate);
            return otherQuadrate;
        }
        /**
         * аналогичная ситуация и для второго квадрата,
         * поскольку условия выше исключают у него наличие детей
         * и возможность быть белым
         * то вернется точная копия this квадрата
         * else if (!otherQuadrate.hasChildren()) {
         */
        else if (otherQuadrate.equals(Q.black)) {
            System.out.println(this + "\n+\n" + otherQuadrate + "\n=\n" + this);
            return this;
        }
        /**
         * невыполнение ни одного из вышеупомянуты условий означает что мы имеет 2 квадрата
         * у каждого из которых есть дети, else аналонично условию:
         *  else if(this.hasChildren() && otherQuadrate.hasChildren())
         *  или
         *  else if(!otherQuadrate.equals(Q.black) && !this.equals(Q.black))
         *  в этом случае мы рекурсивно вызываем функцию слияния для их детей
         */
        else {
            return new Quadrate(
                    this.leftUp.merge(otherQuadrate.leftUp),
                    this.rightUp.merge(otherQuadrate.rightUp),
                    this.leftDown.merge(otherQuadrate.leftDown),
                    this.rightDown.merge(otherQuadrate.rightDown)
            );
        }
    }

    @Override
    public String toString() {
        if (this.equals(Q.white)) {
            return "[white]";
        }
        if (this.equals(Q.black)) {
            return "[black]";
        }
        return "[" + leftUp +
                ", " + rightUp +
                ", " + leftDown +
                ", " + rightDown +
                ']';
    }
}

/**
 * public boolean hasChildren() {
 * return this.leftUp != null
 * || this.leftDown != null
 * || this.rightDown != null
 * || this.rightUp != null;
 * }
 * <p>
 * public boolean hasGrandchildren() {
 * if (this.rightUp != null && this.rightUp.hasChildren()) {
 * return true;
 * }
 * if (this.rightDown != null && this.rightDown.hasChildren()) {
 * return true;
 * }
 * if (this.leftUp != null && this.leftUp.hasChildren()) {
 * return true;
 * }
 * if (this.leftDown != null && this.leftDown.hasChildren()) {
 * return true;
 * }
 * return false;
 * }
 */
