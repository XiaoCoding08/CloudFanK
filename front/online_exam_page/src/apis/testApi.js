import httpInstance from "@/utils/http.js";

export function test(){
    return  httpInstance({
        url: '/test',
    })
}