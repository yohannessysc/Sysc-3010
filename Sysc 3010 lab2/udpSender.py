# Source: https://pymotw.com/2/socket/udp.html

import socket, sys, time

host = sys.argv[1]
textport = sys.argv[2]
n = sys.argv[3]

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
port = int(textport)
server_address = (host, port)

d= socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
p = 1007
sa = ('localhost', p)
d.bind(sa)


i = 1
while 1:
    
    while(i<=int(n)):  
        data = "Message " + str(i)
        if not len(data):
            break
#    s.sendall(data.encode('utf-8'))
        s.sendto(data.encode('utf-8'), server_address)
        while True:
            buf, address = d.recvfrom(port)
            if not len(buf):
                break
            print ("Received %s bytes from %s %s: " % (len(buf), address, buf ))
            break
        i= i + 1
    break
    s.shutdown(1)

