package nl.kmartin.civiliancpr.ui.messagesList.adapter

import nl.kmartin.civiliancpr.model.Message

interface MessageClickListener {
    fun onNavigationClick(message: Message)
    fun onStartDeleteActionMode(message: Message)
    fun onDelete(messages: List<Message>)
    fun onShare(message: Message)
    fun onCopy(message: Message)
}