package cn.com.fri.axy.sip.core;

import cn.com.fri.axy.comet.pushlet.MessageSender;
import cn.com.fri.axy.common.util.SysLogger;
import cn.com.fri.axy.sip.entity.Handler;
import cn.com.fri.axy.sip.entity.HandlerList;
import cn.com.fri.axy.sip.message.entity.MessageHandler;
import cn.com.fri.axy.sip.register.entity.RegisterHandler;

import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipServletResponse;
import javax.servlet.sip.SipSession;


public class Controller {
    public void process(SipServletRequest paramSipServletRequest, SipServletResponse paramSipServletResponse) {
        try {
            HandlerList handlerList = new HandlerList();
            SipSession localSipSession;
            if (paramSipServletRequest != null) {
                localSipSession = paramSipServletRequest.getSession();
            } else {
                localSipSession = paramSipServletResponse.getSession();
            }
            Object localObject2;
            if (paramSipServletRequest != null) {

                localObject2 = new RequestContext(paramSipServletRequest);
                SysLogger.info(getClass() + ":\n" +
                        "mainapp get message:\n" + paramSipServletRequest.toString());


                MessageSender.getInstance().send(paramSipServletRequest.toString());
            } else {
                localObject2 = new ResponseContext(paramSipServletResponse);
                SysLogger.info(getClass() + ":\n" +
                        "mainapp get message:\n" + paramSipServletResponse.toString());


                MessageSender.getInstance().send(paramSipServletResponse.toString());
            }


            if ((paramSipServletRequest != null) && (paramSipServletRequest.isInitial())) {


                if (((MessageContext) localObject2).isInvite()) {


                    return;
                }
                if (((MessageContext) localObject2).isMessage()) {
                    SysLogger.info(getClass() + ":\n" + "the new message session");
                    ((HandlerList) handlerList).add(new MessageHandler());
                    ((MessageContext) localObject2).getSession().setAttribute("handlerList", handlerList);

                } else if (((MessageContext) localObject2).isRegister()) {
                    ((HandlerList) handlerList).add(new RegisterHandler());
                    ((MessageContext) localObject2).getSession().setAttribute("handlerList",
                            handlerList);
                } else {
                    SysLogger.info(
                            getClass() + ":\n" + "server do not deal the message " + ((MessageContext) localObject2).getRequest().toString());


                }


            } else {


                handlerList = (HandlerList) localSipSession.getAttribute("handlerList");
            }

            if (handlerList == null) {
                SysLogger.info(

                        getClass() + ":\n" + "handlist is null, can do nothing for the message" + localObject2.toString());
            }


            execute((HandlerList) handlerList, (MessageContext) localObject2);
            return;
        } catch (Exception localException) {
            Object localObject1;
            SysLogger.info(localObject1 = localException);
        }
    }


    protected void execute(HandlerList paramHandlerList, MessageContext paramMessageContext) {
        if (paramHandlerList == null) {
            SysLogger.info(getClass() + "\nhandlerList is null");
            return;
        }

        for (int i = 0;

             i < paramHandlerList.size(); i++) {
            SysLogger.info(getClass() + "\nhandler:" + i);
            Object localObject = paramHandlerList.get(i);
            try {
                execute((Handler) localObject, paramMessageContext);
            } catch (Exception localException) {
                SysLogger.printStackTrace(localException);
            }
        }
    }


    protected void execute(Handler paramHandler, MessageContext paramMessageContext) {
        if (paramHandler == null) {
            return;
        }

        if (paramMessageContext.isRequest()) {
            if (paramMessageContext.isInvite()) {

                if (paramMessageContext.isInitial()) {
                    paramHandler.doInvite(paramMessageContext);
                    return;
                }


                paramHandler.doReInvite(paramMessageContext);
                return;
            }


            if (paramMessageContext.isRegister()) {
                paramHandler.doRegister(paramMessageContext);
                return;
            }

            if (paramMessageContext.isMessage()) {
                paramHandler.doMessage(paramMessageContext);
                return;
            }
            if (paramMessageContext.isAck()) {
                paramHandler.doAck(paramMessageContext);
                return;
            }
            if (paramMessageContext.isBye()) {
                paramHandler.doBye(paramMessageContext);
                return;
            }
            if (paramMessageContext.isCancel()) {
                paramHandler.doCancel(paramMessageContext);
                return;
            }
            if (paramMessageContext.isInfo()) {
                paramHandler.doInfo(paramMessageContext);
                return;
            }
            if (paramMessageContext.isPrack()) {
                paramHandler.doPrack(paramMessageContext);
                return;
            }
            if (paramMessageContext.isRefer()) {
                paramHandler.doRefer(paramMessageContext);
                return;
            }

            if (paramMessageContext.isUpdate()) {
                paramHandler.doUpdate(paramMessageContext);
                return;
            }
            if (paramMessageContext.isPublish()) {
                paramHandler.doPublish(paramMessageContext);
            }


        } else {

            int status = paramMessageContext.getResponse().getStatus();
            if (status < 200) {
                paramHandler.doProvisionalResponse(paramMessageContext);
                return;
            }
            if (status < 300) {
                paramHandler.doSuccessResponse(paramMessageContext);
                return;
            }
            if (status < 400) {
                paramHandler.doRedirectResponse(paramMessageContext);
                return;
            }


            paramHandler.doErrorResponse(paramMessageContext);
        }
    }
}


/* Location:home/wuqf/Desktop/sip.jar!/cn/com/fri/axy/sip/core/Controller.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */