package com.somanathdevs.pawpalace.event;

import org.springframework.context.ApplicationEvent;

public class TransactionalEvent extends ApplicationEvent {
        public TransactionalEvent(Object source) {
                super(source);
        }
}