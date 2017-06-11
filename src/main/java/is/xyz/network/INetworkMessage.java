package is.xyz.network;

import java.io.Serializable;

/**
 * Created by Admin on 11.06.2017.
 */
public interface INetworkMessage extends Serializable{
    void work(NetworkManager manager);
}
