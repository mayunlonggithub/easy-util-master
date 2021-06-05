package zju.edu.als;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zju.edu.als.execption.ExecuteException;
import zju.edu.als.execption.ExecutorNotFoundExecption;
import zju.edu.als.executor.GeneralExecutor;
import zju.edu.als.executor.Python3Executor;
import zju.edu.als.executor.Python2Executor;
import zju.edu.als.factory.DefaultExecutorFactory;
import zju.edu.als.model.Test;


/**
 * @author Ma
 * @create 2019-09-13 17:31
 */
public class MainWorker {
    private static Logger log = LoggerFactory.getLogger(MainWorker.class);

    private static final String HOME = "D:/Java_develop/COVIDNet-CT/";
    public <T> T getjson(Class<T> resType,String url) throws ExecutorNotFoundExecption, ExecuteException {
        GeneralExecutor general = DefaultExecutorFactory.getExecutor(GeneralExecutor.class);
        /*
         */
        Python3Executor python2 = DefaultExecutorFactory.getExecutor(Python3Executor.class);
        return python2.execute(resType, HOME + "run_covidnet_ct.py", url);
    }
    public static void main(String[] args) throws ExecutorNotFoundExecption, ExecuteException {
        GeneralExecutor general = DefaultExecutorFactory.getExecutor(GeneralExecutor.class);
        /*
         */
        Python3Executor python2 = DefaultExecutorFactory.getExecutor(Python3Executor.class);
        JSONObject test = python2.execute(JSONObject.class, HOME + "run_covidnet_ct.py", "infer");
        System.out.println("NCP is "+test.getString("NCP"));
        System.out.println("tuber is "+test.getString("tuber"));
        System.out.println("Normal is "+test.getString("Normal"));

    }
}