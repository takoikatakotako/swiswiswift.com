+++
title = "lsmod（LPIC）"
url = "2022-10-05"
date = "2022-10-05"
description = "lsmod（LPIC）"
tags = [
  "Linux"
]
categories = [
  "Linux"
]
archives = "2021/10"
aliases = ["migrate-from-jekyl"]
+++

<br>

# lsmod

現在システムにロードされているモジュールの状態を表示するコマンドです。
またモジュールの状態は `/proc/modules` に格納されています。

```
$ lsmod
```

```
Module                  Size  Used by
xt_recent              24576  0
xt_multiport           20480  1
tls                   106496  0
intel_rapl_msr         20480  0
intel_rapl_common      36864  1 intel_rapl_msr
joydev                 32768  0
input_leds             16384  0
serio_raw              20480  0
mac_hid                16384  0
xt_hl                  16384  22
ip6_tables             32768  52
ip6t_rt                20480  3
ip6t_REJECT            16384  3
nf_reject_ipv6         20480  1 ip6t_REJECT
xt_LOG                 20480  10
nf_log_syslog          20480  10
xt_comment             16384  2
nft_limit              16384  13
xt_limit               16384  0
xt_addrtype            16384  4
xt_tcpudp              20480  20
xt_conntrack           16384  16
nf_conntrack          167936  1 xt_conntrack
nf_defrag_ipv6         24576  1 nf_conntrack
nf_defrag_ipv4         16384  1 nf_conntrack
ipt_REJECT             16384  110
nf_reject_ipv4         16384  1 ipt_REJECT
nft_compat             20480  251
nft_counter            16384  283
nf_tables             241664  611 nft_compat,nft_counter,nft_limit
nfnetlink              20480  2 nft_compat,nf_tables
ramoops                32768  0
pstore_blk             16384  0
reed_solomon           28672  1 ramoops
pstore_zone            28672  1 pstore_blk
mtd                    73728  0
sch_fq_codel           20480  2
dm_multipath           40960  0
scsi_dh_rdac           20480  0
scsi_dh_emc            16384  0
ipmi_devintf           20480  0
efi_pstore             16384  0
scsi_dh_alua           20480  0
ipmi_msghandler       122880  1 ipmi_devintf
msr                    16384  0
ip_tables              32768  8
x_tables               53248  15 xt_conntrack,nft_compat,xt_LOG,xt_multiport,xt_tcpudp,xt_addrtype,xt_recent,ip6t_rt,xt_comment,ip6_tables,ipt_REJECT,ip_tables,xt_limit,xt_hl,ip6t_REJECT
autofs4                49152  2
btrfs                1527808  0
blake2b_generic        20480  0
zstd_compress         229376  1 btrfs
raid10                 69632  0
raid456               163840  0
async_raid6_recov      24576  1 raid456
async_memcpy           20480  2 raid456,async_raid6_recov
async_pq               24576  2 raid456,async_raid6_recov
async_xor              20480  3 async_pq,raid456,async_raid6_recov
async_tx               20480  5 async_pq,async_memcpy,async_xor,raid456,async_raid6_recov
xor                    24576  2 async_xor,btrfs
raid6_pq              122880  4 async_pq,btrfs,raid456,async_raid6_recov
libcrc32c              16384  4 nf_conntrack,btrfs,nf_tables,raid456
raid1                  49152  0
raid0                  24576  0
multipath              20480  0
linear                 20480  0
hid_generic            16384  0
bochs                  16384  0
crct10dif_pclmul       16384  1
crc32_pclmul           16384  0
drm_vram_helper        24576  1 bochs
ghash_clmulni_intel    16384  0
drm_ttm_helper         16384  2 bochs,drm_vram_helper
ttm                    86016  2 drm_vram_helper,drm_ttm_helper
drm_kms_helper        307200  4 bochs,drm_vram_helper
syscopyarea            16384  1 drm_kms_helper
sysfillrect            20480  1 drm_kms_helper
sysimgblt              16384  1 drm_kms_helper
aesni_intel           376832  0
crypto_simd            16384  1 aesni_intel
fb_sys_fops            16384  1 drm_kms_helper
cryptd                 24576  2 crypto_simd,ghash_clmulni_intel
cec                    61440  1 drm_kms_helper
usbhid                 65536  0
rc_core                65536  1 cec
virtio_net             61440  0
net_failover           20480  1 virtio_net
psmouse               176128  0
virtio_blk             20480  1
drm                   606208  6 drm_kms_helper,bochs,drm_vram_helper,drm_ttm_helper,ttm
failover               16384  1 net_failover
i2c_piix4              28672  0
hid                   147456  2 usbhid,hid_generic
pata_acpi              16384  0
floppy                118784  0
```


```
$ cat /proc/modules
```


```
xt_recent 24576 0 - Live 0xffffffffc0869000
xt_multiport 20480 1 - Live 0xffffffffc0853000
tls 106496 0 - Live 0xffffffffc0917000
intel_rapl_msr 20480 0 - Live 0xffffffffc0859000
intel_rapl_common 36864 1 intel_rapl_msr, Live 0xffffffffc0839000
joydev 32768 0 - Live 0xffffffffc07b8000
input_leds 16384 0 - Live 0xffffffffc07b3000
serio_raw 20480 0 - Live 0xffffffffc07ad000
mac_hid 16384 0 - Live 0xffffffffc07a8000
xt_hl 16384 22 - Live 0xffffffffc07a3000
ip6_tables 32768 52 - Live 0xffffffffc079a000
ip6t_rt 20480 3 - Live 0xffffffffc0794000
ip6t_REJECT 16384 3 - Live 0xffffffffc078f000
nf_reject_ipv6 20480 1 ip6t_REJECT, Live 0xffffffffc0789000
xt_LOG 20480 10 - Live 0xffffffffc0783000
nf_log_syslog 20480 10 - Live 0xffffffffc077d000
xt_comment 16384 2 - Live 0xffffffffc0778000
nft_limit 16384 13 - Live 0xffffffffc0773000
xt_limit 16384 0 - Live 0xffffffffc076e000
xt_addrtype 16384 4 - Live 0xffffffffc0769000
xt_tcpudp 20480 20 - Live 0xffffffffc071b000
xt_conntrack 16384 16 - Live 0xffffffffc0764000
nf_conntrack 167936 1 xt_conntrack, Live 0xffffffffc073a000
nf_defrag_ipv6 24576 1 nf_conntrack, Live 0xffffffffc0733000
nf_defrag_ipv4 16384 1 nf_conntrack, Live 0xffffffffc072e000
ipt_REJECT 16384 110 - Live 0xffffffffc0729000
nf_reject_ipv4 16384 1 ipt_REJECT, Live 0xffffffffc0724000
nft_compat 20480 251 - Live 0xffffffffc0715000
nft_counter 16384 283 - Live 0xffffffffc0710000
nf_tables 241664 611 nft_limit,nft_compat,nft_counter, Live 0xffffffffc06d4000
nfnetlink 20480 2 nft_compat,nf_tables, Live 0xffffffffc06ce000
ramoops 32768 0 - Live 0xffffffffc06b5000
pstore_blk 16384 0 - Live 0xffffffffc06c9000
reed_solomon 28672 1 ramoops, Live 0xffffffffc06bf000
pstore_zone 28672 1 pstore_blk, Live 0xffffffffc06a1000
mtd 73728 0 - Live 0xffffffffc066a000
sch_fq_codel 20480 2 - Live 0xffffffffc0664000
dm_multipath 40960 0 - Live 0xffffffffc0654000
scsi_dh_rdac 20480 0 - Live 0xffffffffc064e000
scsi_dh_emc 16384 0 - Live 0xffffffffc0649000
ipmi_devintf 20480 0 - Live 0xffffffffc0640000
efi_pstore 16384 0 - Live 0xffffffffc062f000
scsi_dh_alua 20480 0 - Live 0xffffffffc0636000
ipmi_msghandler 122880 1 ipmi_devintf, Live 0xffffffffc0610000
msr 16384 0 - Live 0xffffffffc060b000
ip_tables 32768 8 - Live 0xffffffffc05e6000
x_tables 53248 15 xt_recent,xt_multiport,xt_hl,ip6_tables,ip6t_rt,ip6t_REJECT,xt_LOG,xt_comment,xt_limit,xt_addrtype,xt_tcpudp,xt_conntrack,ipt_REJECT,nft_compat,ip_tables, Live 0xffffffffc05d8000
autofs4 49152 2 - Live 0xffffffffc05cb000
btrfs 1527808 0 - Live 0xffffffffc0455000
blake2b_generic 20480 0 - Live 0xffffffffc044f000
zstd_compress 229376 1 btrfs, Live 0xffffffffc0416000
raid10 69632 0 - Live 0xffffffffc0404000
raid456 163840 0 - Live 0xffffffffc03db000
async_raid6_recov 24576 1 raid456, Live 0xffffffffc03d4000
async_memcpy 20480 2 raid456,async_raid6_recov, Live 0xffffffffc03ce000
async_pq 24576 2 raid456,async_raid6_recov, Live 0xffffffffc03c7000
async_xor 20480 3 raid456,async_raid6_recov,async_pq, Live 0xffffffffc03c1000
async_tx 20480 5 raid456,async_raid6_recov,async_memcpy,async_pq,async_xor, Live 0xffffffffc03bb000
xor 24576 2 btrfs,async_xor, Live 0xffffffffc03b4000
raid6_pq 122880 4 btrfs,raid456,async_raid6_recov,async_pq, Live 0xffffffffc0395000
libcrc32c 16384 4 nf_conntrack,nf_tables,btrfs,raid456, Live 0xffffffffc0279000
raid1 49152 0 - Live 0xffffffffc0388000
raid0 24576 0 - Live 0xffffffffc0381000
multipath 20480 0 - Live 0xffffffffc037b000
linear 20480 0 - Live 0xffffffffc0375000
hid_generic 16384 0 - Live 0xffffffffc0370000
bochs 16384 0 - Live 0xffffffffc036b000
crct10dif_pclmul 16384 1 - Live 0xffffffffc0366000
crc32_pclmul 16384 0 - Live 0xffffffffc0361000
drm_vram_helper 24576 1 bochs, Live 0xffffffffc02f1000
ghash_clmulni_intel 16384 0 - Live 0xffffffffc02ec000
drm_ttm_helper 16384 2 bochs,drm_vram_helper, Live 0xffffffffc0109000
ttm 86016 2 drm_vram_helper,drm_ttm_helper, Live 0xffffffffc034b000
drm_kms_helper 307200 4 bochs,drm_vram_helper, Live 0xffffffffc02ff000
syscopyarea 16384 1 drm_kms_helper, Live 0xffffffffc02fa000
sysfillrect 20480 1 drm_kms_helper, Live 0xffffffffc025b000
sysimgblt 16384 1 drm_kms_helper, Live 0xffffffffc013e000
aesni_intel 376832 0 - Live 0xffffffffc028f000
crypto_simd 16384 1 aesni_intel, Live 0xffffffffc0219000
fb_sys_fops 16384 1 drm_kms_helper, Live 0xffffffffc0256000
cryptd 24576 2 ghash_clmulni_intel,crypto_simd, Live 0xffffffffc0212000
cec 61440 1 drm_kms_helper, Live 0xffffffffc027f000
usbhid 65536 0 - Live 0xffffffffc0201000
rc_core 65536 1 cec, Live 0xffffffffc01f0000
virtio_net 61440 0 - Live 0xffffffffc0269000
net_failover 20480 1 virtio_net, Live 0xffffffffc0263000
psmouse 176128 0 - Live 0xffffffffc022a000
virtio_blk 20480 1 - Live 0xffffffffc0220000
drm 606208 6 bochs,drm_vram_helper,drm_ttm_helper,ttm,drm_kms_helper, Live 0xffffffffc015b000
failover 16384 1 net_failover, Live 0xffffffffc0153000
i2c_piix4 28672 0 - Live 0xffffffffc0147000
hid 147456 2 hid_generic,usbhid, Live 0xffffffffc0119000
pata_acpi 16384 0 - Live 0xffffffffc0111000
floppy 118784 0 - Live 0xffffffffc00eb000
```
