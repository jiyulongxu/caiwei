package com.caiwei.console.web.controller;

import com.caiwei.console.web.domain.DataDictionaryVO;
import com.caiwei.console.web.service.IDataDictionaryService;
import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
@RequestMapping("/terms")
public class TermsController extends AbstractController {

    private static Logger logger = LoggerFactory.getLogger(TermsController.class);

    @Autowired
    private IDataDictionaryService dataDictionaryService;

    @RequestMapping("/index")
    public String index() {
        return "/dataset/terms";
    }

    @RequestMapping("/dictionary")
    public String dictionary() {
        return "/dataset/dictionary";
    }

    @ResponseBody
    @RequestMapping("/queryTermsCodeByParam")
    public DataDictionaryVO queryTermsCodeByParam(DataDictionaryVO dataDictionaryVO) {
        return dataDictionaryService.queryTermsCodeByParam(dataDictionaryVO);
    }

    @ResponseBody
    @RequestMapping("/findTermsCodeByID")
    public ResponseVO<DataDictionaryVO> findTermsCodeByID(@RequestBody DataDictionaryVO dataDictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(dataDictionaryService.queryTermsCodeByID(dataDictionaryVO));
        } catch (BusinessException e) {
            responseVO = returnError(e.getMessage());
        }
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/deleteTermsCode")
    public ResponseVO<String> deleteTermsCode(@RequestBody DataDictionaryVO dataDictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            dataDictionaryService.deleteTermsCode(dataDictionaryVO);
        } catch (BusinessException e) {
            responseVO = returnError(e.getMessage());
        }
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/updateTermsCode")
    public ResponseVO<String> updateTermsCode(@RequestBody DataDictionaryVO dataDictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            dataDictionaryService.updateTermsCode(dataDictionaryVO);
        } catch (BusinessException e) {
            responseVO = returnError(e.getMessage());
        }
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/queryDataDictionaryByTermsCode")
    public DataDictionaryVO queryDataDictionaryByTermsCode(DataDictionaryVO dataDictionaryVO) {
        return dataDictionaryService.queryDataDictionaryByTermsCode(dataDictionaryVO);
    }

    @ResponseBody
    @RequestMapping("/queryDataDictionaryValueByTermsValue")
    public DataDictionaryVO queryDataDictionaryValueByTermsValue(DataDictionaryVO dataDictionaryVO) {
        return dataDictionaryService.queryDataDictionaryValueByTermsValue(dataDictionaryVO);
    }

    @ResponseBody
    @RequestMapping("/deleteDataDictionaryValue")
    public ResponseVO<String> deleteDataDictionaryValue(@RequestBody DataDictionaryVO dataDictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            dataDictionaryService.deleteDataDictionaryValue(dataDictionaryVO);
        } catch (BusinessException e) {
            responseVO = returnError(e.getMessage());
            logger.error("",e);
        }
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/addTermsCode")
    public ResponseVO<String> addTermsCode(@RequestBody DataDictionaryVO dataDictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            dataDictionaryService.addTermsCode(dataDictionaryVO);
        } catch (BusinessException e) {
            responseVO = returnError(e.getMessage());
            logger.error("",e);
        }
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/addTermsValue")
    public ResponseVO<String> addTermsValue(@RequestBody DataDictionaryVO dataDictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            dataDictionaryService.addTermsValue(dataDictionaryVO);
        } catch (BusinessException e) {
            responseVO = returnError(e.getMessage());
            logger.error("",e);
        }
        return responseVO;
    }


    @ResponseBody
    @RequestMapping("/findDataDictionaryById")
    public ResponseVO<DataDictionaryVO> findDataDictionaryById(@RequestBody DataDictionaryVO dataDictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            responseVO.setResult(dataDictionaryService.findDataDictionaryById(dataDictionaryVO));
        } catch (BusinessException e) {
            responseVO = returnError(e.getMessage());
        }
        return responseVO;
    }


    @ResponseBody
    @RequestMapping("/updateDataDictionary")
    public ResponseVO<String> updateDataDictionary(@RequestBody DataDictionaryVO dataDictionaryVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            dataDictionaryService.updateDataDictionary(dataDictionaryVO);
        } catch (BusinessException e) {
            responseVO = returnError(e.getMessage());
        }
        return responseVO;
    }

}
