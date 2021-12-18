import axios from "axios";
import React, {useState, useEffect} from "react";

export const Hello = () => {

    const [hellos, setHellos] = useState<any>([])

    const fetchUsers = () => {
        axios.get("http://localhost:8080/hello").then(res => {
            console.log(res);
            setHellos(res.data);
        })
    }

    useEffect(() => {
        fetchUsers();
    }, [])

    return hellos.map((hello: any, index: any) => {
        return (
            <div key={index}>
                <h1>{hello.message}</h1>
            </div>
        )
    })
}
