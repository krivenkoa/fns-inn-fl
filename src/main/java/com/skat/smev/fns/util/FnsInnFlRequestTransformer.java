package com.skat.smev.fns.util;


import org.apache.log4j.Logger;
import com.skat.smev.fns.domain.*;
import com.skat.smev.fns.model.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeFactory;

public class FnsInnFlRequestTransformer {
    private static final Logger LOGGER = Logger.getLogger(FnsInnFlRequestTransformer.class.getName());

    /*ИНН ФЛ: Запрос*/
    public static FNSINNSingularRequest createFNSINNSingularRequest(RequestModel model){
        ObjectFactory innflObjectFactory = new ObjectFactory();

        // create InnFLReq
        FNSINNSingularRequest innflReq = innflObjectFactory.createFNSINNSingularRequest();
        innflReq.setИдЗапрос(model.getRequestId());
        innflReq.setСведФЛ(getSvedFL(innflObjectFactory, model));
        innflReq.setСведЮЛ(getSvedUL(innflObjectFactory, model));

        return innflReq;
    }

  /**
     * Метод выполняет преобразование ответа от СМЭВ-адаптера в формат {@link BaseMessageModel}
     * @param adapterResponseModel ответ от СМЭВ-адаптера по ИНН ФЛ от ФНС
     * @return формированный ответ для дальнейшей отправки в ВИС
     * @throws Exception
     */
    public static BaseMessageModel parseINNFlResponseFromAdapter(AdapterResponseModel adapterResponseModel) throws Exception {
        LOGGER.info("Try to parse response from adapter");
        LOGGER.info("Response: " + adapterResponseModel);

        if(adapterResponseModel.getResponse() != null){
            String xml = Base64Util.getXmlFromBase64(adapterResponseModel.getResponse());
            final FNSINNSingularResponse response = XmlUtil.unmarshal(xml, FNSINNSingularResponse.class);
            ResponseMessageModel responseMessageModel = new ResponseMessageModel();
            responseMessageModel.setRequestId(response.getИдЗапрос());
            responseMessageModel.setInnFl(response.getИННФЛ());

            responseMessageModel.setMessageId(adapterResponseModel.getMessageId());
            return responseMessageModel;
        } else if(adapterResponseModel.getRejects() != null && !adapterResponseModel.getRejects().isEmpty()){
            return createRejectMessageModel(adapterResponseModel);
        } else {
            return createStatusMessageModel(adapterResponseModel);
        }
    }

    /**/
    private static RejectMessageModel createRejectMessageModel(AdapterResponseModel adapterResponseModel){
        RejectMessageModel rejectMessageModel = new RejectMessageModel();
        rejectMessageModel.setMessageId(adapterResponseModel.getMessageId());
        rejectMessageModel.setRejects(adapterResponseModel.getRejects());
        return rejectMessageModel;
    }

    /**/
    private static StatusMessageModel createStatusMessageModel(AdapterResponseModel adapterResponseModel){
        StatusMessageModel statusMessageModel = new StatusMessageModel();
        statusMessageModel.setMessageId(adapterResponseModel.getMessageId());
        statusMessageModel.setDescription(adapterResponseModel.getDescription());
        return statusMessageModel;
    }

    /**/

    private static СведФЛТип getSvedFL(ObjectFactory factory, RequestModel model){
        // create fio
        ФИОТип fioFl = factory.createФИОТип();
        fioFl.setИмя(model.getNameFl());
        fioFl.setФамилия(model.getSurnameFl());
        fioFl.setОтчество(model.getPatronymicFl());
        // create UdLichnFl
        УдЛичнФЛТип udLichnFl = factory.createУдЛичнФЛТип();
        udLichnFl.setДатаДок(stringToXmlGregorianCalendar(model.getDateDoc()));
        udLichnFl.setВыдДок(model.getVydDoc());
        udLichnFl.setКодВидДок(model.getKodVidDoc());
        udLichnFl.setКодВыдДок(model.getKodVydDoc());
        udLichnFl.setСерНомДок(model.getDocSeriaNum());
        // create Sved FL
        СведФЛТип svedFl = factory.createСведФЛТип();
        svedFl.setФИО(fioFl);
        svedFl.setДатаРожд(stringToXmlGregorianCalendar(model.getDateBirthFl()));
        svedFl.setМестоРожд(model.getPlaceBirth());
        svedFl.setУдЛичнФЛ(udLichnFl);
        return svedFl;
    }

    /**/
    private static FNSINNSingularRequest.СведЮЛ getSvedUL(ObjectFactory factory, RequestModel model) {

        FNSINNSingularRequest.СведЮЛ svedUl = factory.createFNSINNSingularRequestСведЮЛ();
        svedUl.setИННЮЛ(model.getInnUl());
        svedUl.setНаимОрг(model.getOrgName());
        svedUl.setОГРН(model.getOrgnUl());
        return svedUl;
    }

    private static XMLGregorianCalendar stringToXmlGregorianCalendar(String value){

        XMLGregorianCalendar xmlGregCal = null;
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(value);
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);
            xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        }
        catch(java.text.ParseException parseEx){
            LOGGER.error("Incorrect date format (yyyy-MM-dd):"+value, parseEx);
        }
        catch(javax.xml.datatype.DatatypeConfigurationException confEx){
            LOGGER.error("Error while XMLGregorianCalendar created:"+value, confEx);
        }
        return xmlGregCal;
    }
}
