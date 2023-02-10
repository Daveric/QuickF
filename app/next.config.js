const prod = process.env.NODE_ENV === 'production'

const withPWA = require('next-pwa')({
    dest: 'public',
    disable: !prod,
})

module.exports = withPWA({
})
