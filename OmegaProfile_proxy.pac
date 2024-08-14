var FindProxyForURL = function(init, profiles) {
    return function(url, host) {
        "use strict";
        var result = init, scheme = url.substr(0, url.indexOf(":"));
        do {
            result = profiles[result];
            if (typeof result === "function") result = result(url, host, scheme);
        } while (typeof result !== "string" || result.charCodeAt(0) === 43);
        return result;
    };
}("+proxy", {
    "+proxy": function(url, host, scheme) {
        "use strict";
        if (/^127\.0\.0\.1$/.test(host) || /^::1$/.test(host) || /^localhost$/.test(host) || /^10\./.test(host) || /^172\.16\./.test(host) || /^172\.17\./.test(host) || /^172\.18\./.test(host) || /^172\.19\./.test(host) || /^172\.20\./.test(host) || /^172\.21\./.test(host) || /^172\.22\./.test(host) || /^172\.23\./.test(host) || /^172\.24\./.test(host) || /^172\.25\./.test(host) || /^172\.26\./.test(host) || /^172\.27\./.test(host) || /^172\.28\./.test(host) || /^172\.29\./.test(host) || /^172\.30\./.test(host) || /^172\.31\./.test(host) || /^192\.168\./.test(host) || /\.sinoeyes\.com$/.test(host) || /\.pharmeyes\.local$/.test(host) || /\.qys\.local$/.test(host) || /\.pharmeyes\.sit$/.test(host)) return "DIRECT";
        return "SOCKS5 192.168.10.102:7890; SOCKS 192.168.10.102:7890";
    }
});