//s326182
//Ammar Ahmed

package com.company;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static int maks(int[] a) { //maks metoden

        if (a.length == 0) { // må ha == om  man skal sjekke noe
            throw new NoSuchElementException("Tabellen er tom!");
        }

        for (int i = 1; i < a.length; i++) { //lager en for-løkke for å gå framover i tabellen
            if (a[i - 1] > a[i]) { //hvis a[0] er større enn a[1]


                int temp = a[i - 1]; // lager en midlertidig variabel a[0]
                a[i - 1] = a[i];
                a[i] = temp;
            }
        }
        return a[a.length - 1];


    }

    //antall ombyttinger
    public static int ombyttinger(int[] a) {
        int antallOmbyttinger = 0;

        for (int i = 1; i < a.length; i++) { //lager en for-løkke for å gå framover i tabellen
            if (a[i - 1] > a[i]) { //hvis a[0] er større enn a[1]

                int temp = a[i - 1]; // lager en midlertidig variabel a[0]
                a[i - 1] = a[i];
                a[i] = temp;

                antallOmbyttinger++;
            }
        }
        return antallOmbyttinger;
    }

    //oppgave 2
    public static int antallUlikeSortert(int[] a) { //sjekke antall ulike verdier det er i en array

        if (a.length == 0) { //hvis lengden av tabellen er 0
            return 0; //returner 0
        }

        for (int i = 1; i < a.length; i++) { //lager en for løkke for å gå gjennom tabellen
            if (a[i - 1] > a[i]) {
                throw new IllegalStateException("Tabellen er ikke sortert!");
            }
        }

        int counter = 1;

        for (int j = 1; j < a.length; j++) {
            if (a[j] == a[j - 1]) {

            } else {
                counter++;
            }
        }
        return counter;

    }

    // Oppgave 3

    public static int antallUlikeUsortert(int[] a) {

        if (a.length < 1) {
            return 0;
        }
        int counter1 = 0;
        int stoerst = a[0];
        for (int i : a) { //for each løkke
            if (stoerst < i) {
                stoerst = i;
            }
        }
        for (int j = 0; j <= stoerst; j++) {
            for (int k = 0; k < a.length; k++) {
                if (a[k] == j) {
                    counter1++;
                    break;

                }
            }
        }
        return counter1;
    }

    //Oppgave 4

    public static int[] delsortering(int[] a) {
        int[] test = a.clone();

        int antallOddetall = 0; //counter

        for (int k = 0; k < a.length; k++) {
            if (a[k] % 2 != 0) { //sjekker antall rest, (partall oddetall)

                int temp = a[antallOddetall];
                a[antallOddetall] = a[k];
                a[k] = temp;
                antallOddetall++;
            }
        }
        if (antallOddetall == 0 || antallOddetall == a.length) {
            //er ikke vits å sortere hvis det er bare partall eller bare oddetall
            Arrays.sort(a);
        } else {

            Arrays.sort(a, 0, antallOddetall);
            Arrays.sort(a, antallOddetall, a.length);
            //delsortering(a);
        }
        return a;
    }

    //Oppgave 5

    public static void rotasjon(char[] a) {
        if (!(a.length == 0)) {
            char[] b = new char[a.length];

            b[0] = a[a.length - 1];

            for (int i = 1; i < a.length; i++) {
                b[i] = a[i - 1];
            }

            for (int j = 0; j < b.length; j++) {
                a[j] = b[j];
            }
        }
    }

    //oppgave 6

    public static void rotasjon(char[] a, int k) {

        int l = a.length; //sjekker om tabellen er tom
        if(l < 2) return;

        if((k %= l) < 0) k += l;

        int s = gcd(l, k); //greatest common divisor

        for(int i = 0; i < s; i++) {
            char verdi = a[i];

            for(int j = i - k, t = i; j != i; j -= k) {
                if(j < 0 ) {
                    j += l;

                }
                a[t] = a[j]; t = j;
            }

            a[i + k] = verdi;
        }
    }

    public static int gcd(int l, int k) {
        return k == 0 ? l : gcd(k, l % k);
    }
    //Oppgave 7a


    public static String flett(String s, String t) {

        StringBuilder sb = new StringBuilder();

        int min = s.length();

        if (s.length() > t.length()) {
            min = t.length();
        }

        for (int i = 0; i < min; i++) {
            sb.append(s.charAt(i)); //append betyr å legge til
            sb.append(t.charAt(i));
        }

        sb.append(s.substring(min));
        sb.append(t.substring(min));



      /*  int[] c = new int[s.length() + t.length()];
        int k = Math.min(s.length(), t.length());

        for (int i = 0; i < k; i++) {
            c[2 * i] = s.charAt(i);
            c[2 * i + 1] = t.charAt(i); //bruk charAt hvis du skal bruke String til array
        }
        System.arraycopy(s, k, c, 2 * k, s.length() - k);
        System.arraycopy(t, k, c, 2 * k, t.length() - k);

        String test = String.valueOf(c);*/

        return sb.toString();
    }


    //Oppgave 7b

    public static String flett(String... s) {
        StringBuilder sb = new StringBuilder();

        int max = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > max) max = s[i].length();
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j].length() <= i) {
                    continue;
                } else {

                    sb.append(s[j].charAt(i));
                    continue;
                }
            }
        }
        return sb.toString();
    }

    //Oppgave 8
    public static int[] indekssortering(int[] a){
            int[] indeks = new int[a.length];

            int[] aHTabell = a.clone(); //HTabell er en hjelpetabell
            Arrays.sort(aHTabell);

            for (int i = 0; i < aHTabell.length; i++) {
                for (int j = 0; j < a.length; j++) {

                    if (aHTabell[i] == a[j]) {
                        indeks[i] = j;

                    }
                }
            }
            return indeks;

        }

        //Oppgave 9

    public static int[] tredjeMin(int[] a) {
        int n = a.length; //tabellens lengde

        if (n < 3) { //lengden må ha minst 3 verdier
            throw new NoSuchElementException("a.length(" + n + ") <3!");
        }

        int[] indeks = indekssortering(Arrays.copyOf(a,3));

        int m = indeks[0]; //indeks til minste verdi
        int nm = indeks[1]; //indeks til nest minste verdi
        int tm = indeks[2]; //indeks til tredje minste verdi

        int minverdi = a[m];
        int nestminverdi = a[nm];
        int tredjeminverdi = a[tm];

        for (int i = 3; i < n; i++) { //kjører gjennom løkka
            int verdi = a[i];

            if(verdi < tredjeminverdi) {
                if (verdi < nestminverdi) {
                    if (verdi < minverdi) {

                        tm = nm;
                        tredjeminverdi = nestminverdi;

                        nm = m;
                        nestminverdi = minverdi;

                        m = i;
                        minverdi = verdi;
                    }
                    else {
                        tm = nm;
                        tredjeminverdi = nestminverdi;

                        nm = i;
                        nestminverdi = verdi;
                    }
                }
                else {
                    tm = i;
                    tredjeminverdi = verdi;
                }
            }
        }
        return new int[] {m,nm,tm};
    }

    //Oppgave 10

    public static int bokstavNr(char bokstav) {
        if (bokstav <= 'Z') return bokstav - 'A';
        else if (bokstav == 'Ø') return 27;
        else if (bokstav == 'A') return 28;
        else return 26;
    }

    public static boolean inneholdt(String a, String b)
    {
        if(a.length() > b.length()) return false;

        int[] antall = new int[29];
        for (int i = 0; i < a.length(); i++) antall[bokstavNr(a.charAt(i))]++;

        for(int i = 0; i < b.length(); i++) antall[bokstavNr(b.charAt(i))]--;

        for (int i = 0; i < antall.length; i++)
            if (antall[i] > 0) return false;

        return true;
    }

    //En annen metode

   /* public static boolean inneholdt2(String a, String b){
        if(a.length() > b.length()) return false; // a har flere bokstaver enn b

        int[] antall = new int[256];
        int n = a.length(), m = b.length();

        for(int i = 0; i < n; i++) antall[a.charAt(i)]++;
        for(int i = 0; i < m; i++) antall[b.charAt(i)]--;

        for (int i = 0; i < antall.length; i++)
            if(antall[i] > 0) return false;

        return true;
    }*/

} //oblig 1





