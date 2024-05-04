package listeners;

import constants.PathConfig;
import enums.TestCaseDetails;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import utilities.CsvReaderUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {

    List<IMethodInstance> testList = new ArrayList<>();
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        List<Map<String,String>> mapList = new ArrayList<>();

        try{
            mapList.addAll(CsvReaderUtility.read(new File(PathConfig.RUNSETUP)));
            testList =getListOfTestCasesToRun(list, mapList);
        }catch (IOException e){
            e.printStackTrace();
        }
        return testList;
    }

    private List<IMethodInstance> getListOfTestCasesToRun(List<IMethodInstance> methods, List<Map<String, String>> mapList){
        for(IMethodInstance method : methods){
            for(Map<String, String> map : mapList){
                if(method.getMethod().getMethodName().equalsIgnoreCase(map.get(TestCaseDetails.NAME.toString().toLowerCase())) &&
                        map.get(TestCaseDetails.EXECUTE.toString().toLowerCase()).equalsIgnoreCase("true")) {

                    method.getMethod().setDescription(map.get(TestCaseDetails.DESCRIPTION.toString().toLowerCase()));
                    testList.add(method);
                }
            }
        }
        return testList;
    }
}
