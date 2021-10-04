import com.apiteam.controller.ProcessController;
import com.apiteam.model.response.ResultResponse;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ProcessTest {
    ProcessController processController;

    @Test
    public void addProcess(){
        Integer number1=10,number2=2;
        ResultResponse resultResponse = processController.postResultResponse(number1,number2,"add");
        assertThat(resultResponse.getResult()).isEqualTo(12);
    }
    @Test
    public void subtractionProcess(){
        Integer number1=10,number2=2;
        ResultResponse resultResponse = processController.postResultResponse(number1,number2,"subtraction");
        assertThat(resultResponse.getResult()).isEqualTo(8);
    }
    @Test
    public void multiplicationProcess(){
        Integer number1=10,number2=2;
        ResultResponse resultResponse = processController.postResultResponse(number1,number2,"multiplication");
        assertThat(resultResponse.getResult()).isEqualTo(20);
    }
    @Test
    public void divisionProcess(){
        Integer number1=10,number2=2;
        ResultResponse resultResponse = processController.postResultResponse(number1,number2,"division");
        assertThat(resultResponse.getResult()).isEqualTo(5);
    }
    @Test
    public void sumProcess(){
        Integer number=5;
        ResultResponse resultResponse = processController.getResultResponse(number,"sum");
        assertThat(resultResponse.getResult()).isEqualTo(15);
    }
}

