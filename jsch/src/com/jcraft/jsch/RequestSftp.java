/* -*-mode:java; c-basic-offset:2; -*- */
/*
Copyright (c) 2002,2003 ymnk, JCraft,Inc. All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

  1. Redistributions of source code must retain the above copyright notice,
     this list of conditions and the following disclaimer.

  2. Redistributions in binary form must reproduce the above copyright 
     notice, this list of conditions and the following disclaimer in 
     the documentation and/or other materials provided with the distribution.

  3. The names of the authors may not be used to endorse or promote products
     derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
VISIGOTH SOFTWARE SOCIETY OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package com.jcraft.jsch;

public class RequestSftp implements Request{
  public void request(Session session, Channel channel) throws Exception{
    Buffer buf=new Buffer();
    Packet packet=new Packet(buf);

    packet.reset();
    buf.putByte((byte)98);
    buf.putInt(channel.getRecipient());
    buf.putString("subsystem".getBytes());
//    buf.putByte((byte)1);
    buf.putByte((byte)0);
    buf.putString("sftp".getBytes());
    session.write(packet);

    /*
    buf=session.read(buf);
    buf.getInt();
    buf.getByte();
    buf.getByte();
    int foo=buf.getInt();  // recipient_channel
    */

    /*
    Channel channel1=Channel.getChannel("sftp");
    session.addChannel(channel1);
    channel1.init();
    channel1.setRecipient(foo);
    channel1.lwsize=channel.lwsize;
    channel1.lmpsize=channel.lmpsize;
    channel1.rwsize=channel.rwsize;
    channel1.rmpsize=channel.rmpsize;
    Channel.del(channel);
    channel1.id=channel.id;
    session.channel=channel1; 
    */

  }
}
