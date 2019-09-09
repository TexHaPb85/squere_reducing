public class Main {
    public static void main(String[] args) {
        Quadrate p1 = Q.black;
        Quadrate p2 = Q.black;
        Quadrate p3 = new Quadrate(Q.black,Q.white,Q.white,Q.white);
        Quadrate p4 = Q.black;
        Quadrate leftExampleQuadrate = new Quadrate(p1,p2,p3,p4);

        Quadrate q1 = Q.white;
        Quadrate q2 = new Quadrate(leftExampleQuadrate,Q.white,Q.white,Q.black);
        Quadrate q3 = Q.white;
        Quadrate q4 = Q.black;
        Quadrate rightExampleQuadrate = new Quadrate(q1,q2,q3,q4);

        Quadrate resultOfMerge = leftExampleQuadrate.merge(rightExampleQuadrate);

        System.out.println("expected:");
        System.out.println("[[white], [[black], [white], [white], [black]], [white], [black]]");
        System.out.println("result:");
        System.out.println(resultOfMerge);
    }
}
