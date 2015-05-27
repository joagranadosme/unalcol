package unalcol.random.util;

import unalcol.random.integer.*;
import unalcol.random.raw.RawGenerator;
import static unalcol.service.Service.set;
//
// Unalcol Random generation Pack 1.0 by Jonatan Gómez-Perdomo
// http://disi.unal.edu.co/profesores/jgomezpe/unalcol/random/
//
/**
 * <p>Shuffles an array (vector) of objects</p>
 *
 * <P>
 *
 * <P>
 * <A HREF="http://disi.unal.edu.co/profesores/jgomezpe/source/unalcol/random/util/Shuffle.java">
 * Source code </A> is available.
 * <P>
 *
 * <h3>License</h3>
 *
 * Copyright (c) 2014 by Jonatan Gómez-Perdomo. <br>
 * All rights reserved. <br>
 *
 * <p>Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <ul>
 * <li> Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * <li> Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <li> Neither the name of the copyright owners, their employers, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * </ul>
 * <p>THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 *
 *
 * @author <A HREF="http://disi.unal.edu.co/profesores/jgomezpe"> Jonatan Gomez-Perdomo </A>
 * (E-mail: <A HREF="mailto:jgomezpe@unal.edu.co">jgomezpe@unal.edu.co</A> )
 * @version 1.0
 * @param <T> Type of objects in the array to be shuffled
 */
public class Shuffle<T> {
    
    /**
     * Creates a shuffle method using the default raw generator (Random class)
     */
    public Shuffle(){
    }
    
    /**
     * Creates a shuffle method using the given raw generator
     * @param g Raw generator to be used by the Integer random generator
     */
    public Shuffle( RawGenerator g ){
        set(RawGenerator.class, this, g);
    }
    
    
    /**
     * Generates an array with all the integers in the interval [0,n) stored in a random fashion
     * @param n Sup limit (the generated array has <i>n</i> elements (the integer numbers in the interval [0,n))
     * @return An array with all the integers in the interval [0,n) stored in a random fashion
     */
    public int[] apply(int n) {
        int[] set = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i;
        }
        apply(set);
        return set;
    }

    /**
     * Shuffles the given array of integers
     * @param set Array of integers to be shuffled
     */
    public void apply(int[] set) {
        int m = 0;
        int j, k;
        int temp;
        int n = set.length;
        RawGenerator g = RawGenerator.get(this);
        IntUniform ig = new IntUniform(n, g);
        int[] indices = ig.generate(2 * n);
        for (int i = 0; i < n; i++) {
            j = indices[m];
            m++;
            k = indices[m];
            m++;
            temp = set[j];
            set[j] = set[k];
            set[k] = temp;
        }
    }

    /**
     * Shuffles the given array of Objects
     * @param set Array of objects to be shuffled
     */
    public void apply(T[] set) {
        int m = 0;
        int j, k;
        T temp;
        int n = set.length;
        RawGenerator g = RawGenerator.get(this);
        IntUniform ig = new IntUniform(n, g);
        int[] indices = ig.generate(2 * n);
        for (int i = 0; i < n; i++) {
            j = indices[m];
            m++;
            k = indices[m];
            m++;
            temp = set[j];
            set[j] = set[k];
            set[k] = temp;
        }
    }
}