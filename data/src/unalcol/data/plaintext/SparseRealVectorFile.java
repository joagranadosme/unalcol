/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unalcol.data.plaintext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import unalcol.io.Persistency;
import unalcol.io.ShortTermMemoryReader;
import unalcol.io.WriteService;
import unalcol.reflect.service.ServiceProvider;
import unalcol.reflect.util.ReflectUtil;
import unalcol.types.collection.vector.Vector;
import unalcol.types.real.array.sparse.SparseRealVector;
import unalcol.types.real.array.sparse.SparseRealVectorSimpleReadService;
import unalcol.types.real.array.sparse.SparseRealVectorSimpleWriteService;

/**
 *
 * @author jgomez
 */
public class SparseRealVectorFile {
    public static Vector<SparseRealVector> load(String fileName, char separator) throws IOException{
        SparseRealVectorSimpleReadService read = new SparseRealVectorSimpleReadService(separator);
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        String line = file.readLine();
        String[] dimensions = line.split(""+separator);
        int n = Integer.parseInt(dimensions[0]);
        int d = Integer.parseInt(dimensions[1]);
        Vector<SparseRealVector> data_points = new Vector();
        //System.out.println(" " + n + "," + d );
        StringReader r;
        ShortTermMemoryReader reader;
        for( int i=0; i<n; i++ ){
            r = new StringReader( file.readLine() );
            reader = new ShortTermMemoryReader(r);
            data_points.add(read.read(reader, d));
        }
        file.close();
        return data_points;
    }
    
    public static void main(String[] args){
    	// @TODO Organize this code
/*        try{
            SparseRealVectorSimpleWriteService key = new SparseRealVectorSimpleWriteService(',', false);
            provider.register(key);
            provider.setDefault_service(WriteService.class,SparseRealVector.class,key);
            String fileName = "/home/jgomez/Repository/data/misc/datasets/tr11.mat";
            Vector<SparseRealVector> v = load(fileName, ' ');
            for( int i=0; i<v.size(); i++){
                System.out.println(Persistency.toString(v.get(i)));
            }
            System.out.println(v.size());
        }catch(Exception e){
            e.printStackTrace();
        }
*/        
    }
    
}
