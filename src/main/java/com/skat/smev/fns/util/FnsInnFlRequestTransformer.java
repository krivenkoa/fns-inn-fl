package com.skat.smev.fns.util;


import org.apache.log4j.Logger;
import com.skat.smev.fns.domain.*;
import com.skat.smev.fns.model.*;

public class FnsInnFlRequestTransformer {
    private static final Logger LOGGER = Logger.getLogger(FnsInnFlRequestTransformer.class.getName());

    /*ИНН ФЛ: Запрос*/
    public static FNSINNSingularRequest createFNSINNSingularRequest(RequestModel model){
        ObjectFactory innflObjectFactory = new ObjectFactory();
        FNSINNSingularRequest innflRequest = innflObjectFactory.createFNSINNSingularRequest();
        innflRequest.setИдЗапрос(model.getRequestId());

        //TODO:

        return innflRequest;
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

            // TODO:

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
}
