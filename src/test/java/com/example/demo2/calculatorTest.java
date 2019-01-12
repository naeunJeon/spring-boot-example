package com.example.demo2;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class calculatorTest {
    @Test
    public void 더하기_테스트(){
        //given
        calculator cal = new calculator();
        final int num1 = 3;
        final int num2 = 7;
        //when
        int result = cal.add(num1, num2);
        //then
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 더하기_모킹_테스트(){
        //given
        calculator cal2 = mock(calculator.class);

        final int num1 = 3;
        final int num2 = 7;
        given(cal2.add(num1, num2)).willReturn(8);
        //when
        int result = cal2.add(num1, num2);
        //then
        assertThat(result).isEqualTo(8);
    }
}
