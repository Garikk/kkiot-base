/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.services;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.interfaces.IPluginConnection;

/**
 *
 * @author sayma
 */
public class QueueReceiver {

    private String queueName = "hello";
    private Gson gson = new Gson();

    public void QueueReceiver(String QueueURL, String QueueName, IPluginConnection PinExecutor) {
        this.queueName = QueueName;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(QueueURL);
        Connection connection;
        try {
            connection = factory.newConnection();

            Channel channel = connection.createChannel();

            channel.queueDeclare(queueName, false, false, false, null);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                PluginMessage message = gson.fromJson(new String(delivery.getBody(), "UTF-8"), PluginMessage.class);
                PinExecutor.executePin(message);
            };
            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
            });
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(QueueReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
