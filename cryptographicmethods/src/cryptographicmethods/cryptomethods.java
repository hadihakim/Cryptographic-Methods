package cryptographicmethods;


public class cryptomethods {
 
    static int secretkey(int publicB,int a, int p ){
        
        int keyA = modulo(publicB,a,p);
       
            return keyA;
        
        
    }
    static int generatepublic(int g, int p){
        int b = (int) ((Math.random()*100) + 1);
        int publicB = modulo(g,b,p);
        return publicB;
    }
   public static int gcd(int a, int b) {
    int t;
    while(b != 0){
        t = a;
        a = b;
        b = t%b;
    }
    return a;
}
   private static boolean relativelyPrime(int a, int b) {
    return gcd(a,b) == 1;
}
   public int Rsaphi(int p, int q){
       int phi = (p - 1) * (q - 1);
       return phi;
   }
   public int generateE(int phi){
       int E = 0;
       while(E == 0){
        E = (int) (Math.random() * phi);
       }
       return E;
       
   }
   public int RsaPriv(int e, int phi){
      int d = modInverse(e,phi);
              return d;
   }
   public int RsaMod(int a, int b){
       int mod = a * b;
       return mod;
   }
   static int ElgamalRand(){
       int rand = (int) ((Math.random() * 100) + 1);
       return rand;
   }
   static int[] ElgamalEnc(int g, int p, int publickey,int message){
       int [] cipher = new int[2];
       int c1 = modulo( g,ElgamalRand(), p);
       cipher[0] = c1;
       int k = modulo(publickey,ElgamalRand(),p);
       
       cipher[1] = k * modulo(message,1,p);
       return cipher;
       
   }
   static int ElgamalDec(int[]Enc, int a, int p){
       int key = modulo( Enc[0],a, p);
       int keyinv = modInverse(key, p);
       int message = Enc[1] * keyinv;
       message = modulo(message,1,p);
       return message;
       
   }
  
   
  static int RsaEnc(int message, int e, int mod){
      int Enc = modulo(message, e, mod);
       return Enc;
       }
   static int RsaDec(int Enc, int d, int mod){
       int Dec = modulo(Enc,d,mod);
       return Dec;
   }
   
   static int modInverse(int a, int m)
    {
        int m0 = m;
        int y = 0, x = 1;
 
        if (m == 1)
            return 0;
 
        while (a > 1) {
            // q is quotient
            int q = a / m;
 
            int t = m;
 
            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;
 
            // Update x and y
            y = x - q * y;
            x = t;
        }
 
        // Make x positive
        if (x < 0)
            x += m0;
 
        return x;
    }
       // Iterative Java program to 
// compute modular power

    /* Iterative Function to calculate
       (g^e)%p in O(log g) */
   /* static int power(int g, int e, int p)
    {
        // Initialize result
        int res = 1;     
       
        // Update g if it is more  
        // than or equal to p
        g = g % p; 

       if (g == 0) return 0; // In case g is divisible by p;   

        while (e > 0)
        {
            // If e is odd, multiply g
            // with result
            if((e & 1)==1)
                res = (res * g) % p;
    
            // e must be even now
            // e = e / 2
            e = e >> 1; 
            e = (e * e) % p; 
        }
        return res;
    }*/
    
    ///////////
    static int modulo(int a,int b,int c) {
    long x=1;
    long y=a;
    while(b > 0){
        if(b%2 == 1){
            x=(x*y)%c;
        }
        y = (y*y)%c; // squaring the base
        b /= 2;
    }
    return (int) x%c;
}////////////
    
    
     // shows if a given string is number 
   public static boolean isnum(String s){
       char c ;
       boolean boll = true;
       for (int i = 0; i < s.length(); i++) {
           c = s.charAt(i);
           boll = Character.isDigit(c);
           
           
       }
       
       return boll;
     }

    // Driver Program to test above functions
    public static void main(String args[])
    {
        int g = 4;
        int e = 3;
        int p = 19;
        System.out.println("Power is " + modulo(g, e, p));
        
        int a = 3, m = 11;
       
        // Function call
        System.out.println("Modular inv of "+a+" mod "+m+" is: "+modInverse(a, m));
        System.out.println(relativelyPrime(3, 7));
        int gcd = gcd(a,m);
        System.out.println("gcd of "+a+" and "+m+ " = "+gcd);
        int b;
        System.out.println( b = (int) (Math.random()*100) +1 );
    }
}

