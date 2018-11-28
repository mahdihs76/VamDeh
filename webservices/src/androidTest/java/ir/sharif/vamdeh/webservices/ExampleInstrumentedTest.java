//package test.test.test.webservices;
//
//import android.content.Context;
//import android.support.test.InstrumentationRegistry;
//import android.support.test.runner.AndroidJUnit4;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import java.io.IOException;
//
//import test.test.test.webservices.base.WebserviceException;
//import test.test.test.webservices.webservices.WebserviceHelper;
//import test.test.test.webservices.webservices.rest_auth.registration.RegistrationResponse;
//import test.test.test.webservices.webservices.trust_relation.get_trust_requests_as_requeser.GetTrustRequestsAsRequesterResponse;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Instrumented test, which will execute on an Android device.
// *
// * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
// */
//@RunWith(AndroidJUnit4.class)
//public class ExampleInstrumentedTest {
//    @Test
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("test.test.test.webservices.test", appContext.getPackageName());
//    }
//
//
//    @Test
//    public void testRegister() {
//        for (int i = 0; i < 10; i++) {
//
////            try {
////                RegistrationResponse register = WebserviceHelper.register("salam2", "chetori12341234", "chetori12341234", "salam2@chetori.com");
////            } catch (IOException e) {
////                e.printStackTrace();
////            } catch (WebserviceException e) {
////                e.printStackTrace();
////            }
//        }
//    }
//
//    @Test
//    public void test() {
////        for (int i = 0; i < 10; i++) {
//
//        try {
//            GetTrustRequestsAsRequesterResponse[] trustRequestsAsAcceptor = WebserviceHelper.getTrustRequestsAsRequester();
//            System.out.println(trustRequestsAsAcceptor[0].getActiveTrustValue());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (WebserviceException e) {
//            e.printStackTrace();
//        }
////        }
//    }
//
//
//}
